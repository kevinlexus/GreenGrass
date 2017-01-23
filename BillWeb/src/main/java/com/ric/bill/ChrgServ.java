package com.ric.bill;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.excp.EmptyServ;
import com.ric.bill.excp.ErrorWhileChrg;
import com.ric.bill.excp.TooManyRecursiveCalls;
import com.ric.bill.mm.HouseMng;
import com.ric.bill.mm.KartMng;
import com.ric.bill.mm.LstMng;
import com.ric.bill.mm.MeterLogMng;
import com.ric.bill.mm.ParMng;
import com.ric.bill.mm.ServMng;
import com.ric.bill.mm.TarifMng;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.bs.Org;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.fn.Chng;
import com.ric.bill.model.fn.Chrg;

/**
 * Сервис формирования начисления
 * @author lev
 *
 */
@Service
@Scope("prototype")
@Slf4j
public class ChrgServ {

	@Autowired
	private ParMng parMng;
	@Autowired
	private Config config;
	@Autowired
	private ServMng servMng;
	@Autowired
	private TarifMng tarMng;
	@Autowired
	private HouseMng houseMng;
	@Autowired
	private KartMng kartMng;
	@Autowired
	private MeterLogMng metMng;
	@Autowired
	private LstMng lstMng;
	
	@Autowired
	private ApplicationContext ctx;
	
	//EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;

    //вспомогательные коллекции
    private List<Chrg> prepChrg;
    private HashMap<Serv, BigDecimal> mapServ;
    private HashMap<Serv, BigDecimal> mapVrt;
    //коллекция для формирования потоков
    private List<Serv> servThr;
    
    //флаг ошибки, произошедшей в потоке
    private static Boolean errThread;
    private Calc calc;
    
	//конструктор
    public ChrgServ() {
    	super();
    }

    //внутренний класс, контроля
    private class Control {
		Integer orgId;
    	Integer servId;
    	
    	@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((orgId == null) ? 0 : orgId.hashCode());
			result = prime * result
					+ ((servId == null) ? 0 : servId.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (!(obj instanceof Control)) {
				return false;
			}
			Control other = (Control) obj;
			if (orgId == null) {
				if (other.orgId != null) {
					return false;
				}
			} else if (!orgId.equals(other.orgId)) {
				return false;
			}
			if (servId == null) {
				if (other.servId != null) {
					return false;
				}
			} else if (!servId.equals(other.servId)) {
				return false;
			}
			return true;
		}

		public Control(Integer servId, Integer orgId) {
    		this.orgId=orgId;
    		this.servId=servId;
    		
    		
		}

    }
    
	//получить список N следующих услуг, для расчета в потоках
    private List<Serv> getNextServ(int cnt) {
    	List<Serv> lst = new ArrayList<Serv>(); 
		int i=1;
		Iterator<Serv> itr = servThr.iterator();
		while (itr.hasNext()) {
			Serv serv = itr.next(); 
    		lst.add(serv);
    		itr.remove();
    		i++;
			if (i > cnt) {
				break;
			}
		}
		
    	return lst;
	}
    
    /**
	 * выполнить расчет начисления по лиц.счету
	 * @param kart - объект лиц.счета
	 * @throws ErrorWhileChrg 
	 */
	public Result chrgLsk(Calc calc) throws ErrorWhileChrg {
    	this.calc=calc;
		//log.info("Lsk="+calc.getKart().getLsk()+", FLsk="+calc.getKart().getFlsk());
		Result res = new Result();
		res.err=0;
		//if (1==1) {
		//	return new AsyncResult<Result>(res);
		//}
		
		prepChrg = new ArrayList<Chrg>(0); 

		//для виртуальной услуги	
		mapServ = new HashMap<Serv, BigDecimal>();  
		mapVrt = new HashMap<Serv, BigDecimal>();  

		//список потоков
		List<ChrgThr> trl = new ArrayList<ChrgThr>();
		//найти все услуги, действительные в лиц.счете
		//и создать потоки по кол-ву услуг
		
		Kart kart = calc.getKart();
		//загрузить все услуги
		servThr = kartMng.getAllServ(calc.getReqConfig().getRqn(), calc);
		
		errThread=false;

		for (Serv serv: servThr) {
			//log.info("ChrgServ1: serv={}", serv);
			log.trace("ChrgServ: serv.cd="+serv.getCd()+" serv.id="+serv.getId());
		}
		while (true) {
			log.trace("ChrgServ: Loading servs for threads");
			//получить следующие N услуг, рассчитать их в потоке
			List<Serv> servWork = getNextServ(10);
			if (servWork.isEmpty()) {
				//выйти, если все услуги обработаны
				break;
			}

			List<Future<Result>> frl = new ArrayList<Future<Result>>();

			for (Serv serv : servWork) {
					Future<Result> fut = null;
					ChrgThr chrgThr = ctx.getBean(ChrgThr.class);
 					chrgThr.set(calc, serv, mapServ, mapVrt, prepChrg);
			    	fut = chrgThr.run1();
			    	frl.add(fut);
			    	log.trace("ChrgServ: Begins "+serv.getCd());

			}
			
			//проверить окончание всех потоков
		    int flag2 = 0;
			while (flag2==0) {
				flag2=1;
				for (Future<Result> fut : frl) {
					if (!fut.isDone()) {
						flag2=0;
					} else {
						try {
							if (fut.get().err==1) {
								errThread=true;
							}
						} catch (InterruptedException | ExecutionException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
					}
				}
				
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
		
		
		//если была ошибка в потоке - приостановить выполнение, выйти
		if (errThread) {
			log.info("ChrgServ.chrgLsk: Error in thread, exiting!", 2);
			res.err=1;
			return res;
		}
		
		//сделать коррекцию на сумму разности между основной и виртуальной услуг
		for (Map.Entry<Serv, BigDecimal> entryVrt : mapVrt.entrySet()) {
		    Serv servVrt = entryVrt.getKey();
			//найти сумму, для сравнения, полученную от основных услуг
		    for (Map.Entry<Serv, BigDecimal> entryServ : mapServ.entrySet()) {
				if (entryServ.getKey().equals(servVrt)) {
					BigDecimal diff = entryVrt.getValue().subtract(entryServ.getValue());
					if (diff.compareTo(BigDecimal.ZERO) != 0) {
						//существует разница, найти услугу, куда кинуть округление
						Serv servRound = servVrt.getServRound(); 
						//найти только что добавленные строки начисления, и вписать в одну из них
						boolean flag = false; //флаг, чтобы больше не корректировать, если уже раз найдено
						for (Chrg chrg : prepChrg) {
							if (!flag && chrg.getStatus() == 1 && chrg.getServ().equals(servRound)) {
								flag = true;
								chrg.setSumAmnt(BigDecimal.valueOf(chrg.getSumAmnt()).add(diff).doubleValue()) ;
								chrg.setSumFull(BigDecimal.valueOf(chrg.getSumFull()).add(diff).doubleValue()) ;
							}
						}
					}
				}
			}		    
		}		
		
		return res;
	}



	/**
	 * перенести в архив предыдущее и сохранить новое начисление
	 * @param lsk - лиц.счет передавать строкой!
	 * @throws ErrorWhileChrg 
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void save (Integer lsk) throws ErrorWhileChrg {
		long beginTime = System.currentTimeMillis();

		Integer status;
		if (calc.getReqConfig().getOperTp().equals(1)) {
			// перерасчет
			status=3;
		} else {
			// начисление
			status=1;
		}
		
		Session session = em.unwrap(Session.class);
		Filter filter = session.enableFilter("FILTER_CHRG1");
		
		session.enableFilter("FILTER_CHRG1").setParameter("PERIOD", calc.getReqConfig().getPeriod())
		   .setParameter("STATUS", 1);
		
		//коллекция для сумм по укрупнённым услугам, для нового начисления 
	    MultiKeyMap mapDeb = new MultiKeyMap();

		Kart kart = em.find(Kart.class, lsk); //здесь так, иначе записи не прикрепятся к объекту не из этой сессии!
		
		long endTime1=System.currentTimeMillis()-beginTime;
		beginTime = System.currentTimeMillis();
		
		//ДЕЛЬТА
		//ПОДГОТОВИТЬСЯ для сохранения дельты
		//сгруппировать до укрупнённых услуг текущий расчет по debt
		for (Chrg chrg : prepChrg) { 
			Serv servMain = null;
			try {
				servMain = servMng.getUpper(chrg.getServ(), "serv_tree_kassa");
				//преобразовать к объекту текущей сессии (потому что начисление взято из разных потоков, разных сессий)
				//servMain = em.find(Serv.class, servMain.getId());
			}catch(Exception e) {
				//servMain = chrg.getServ();
			    e.printStackTrace();
				throw new ErrorWhileChrg("ChrgServ.save: ChrgThr: ErrorWhileChrg");
			}
			//Сохранить сумму по укрупнённой услуге, для расчета дельты для debt
			putSumDeb(mapDeb, servMain, chrg.getOrg(), BigDecimal.valueOf(chrg.getSumAmnt()));
		}

		long endTime6=System.currentTimeMillis()-beginTime;

		//сгруппировать до укрупнённых услуг предыдущий расчет по debt
		for (Chrg chrg : kart.getChrg()) {
			//Только необходимые строки
			if (chrg.getStatus().equals(1) && chrg.getPeriod().equals(calc.getReqConfig().getPeriod())) {
				Serv servMain = null;
				
				long endTime7;
				try {
					servMain = servMng.getUpper(chrg.getServ(), "serv_tree_kassa");
					//преобразовать к объекту текущей сессии (потому что начисление взято из таблицы)
					//servMain = em.find(Serv.class, servMain.getId());
				} catch(Exception e) {
				    e.printStackTrace();
					//servMain = chrg.getServ();
					throw new ErrorWhileChrg("ChrgServ.save: ChrgThr: ErrorWhileChrg");
				}
				//Вычесть сумму по укрупнённой услуге из нового начисления, для расчета дельты для debt
				putSumDeb(mapDeb, servMain, chrg.getOrg(), BigDecimal.valueOf(-1d * Utl.nvl(chrg.getSumAmnt(), 0d)));
				
							
			}
		}
		
		long endTime2=System.currentTimeMillis()-beginTime;
		beginTime = System.currentTimeMillis();
		
		//перенести предыдущий расчет начисления в статус "архив" (1->0)
		Query query = null;

		if (calc.getReqConfig().getOperTp().equals(0)) {
			// начисление
			query = em.createNativeQuery("update fn.chrg t set t.status=0 where t.lsk=:lsk "
					+ "and t.status=1 "
					//+ "and t.dt1 between :dt1 and :dt2 " -нет смысла, есть period
					//+ "and t.dt2 between :dt1 and :dt2 "
					+ "and t.period=:period"
					);
		} else if (calc.getReqConfig().getOperTp().equals(1)) {
			// перерасчет
			query = em.createNativeQuery("delete from fn.chrg t where t.lsk=:lsk "
					+ "and t.status=3 "
					+ "and t.period=:period "
					+ "and t.fk_chng=:chngId "
					);
			query.setParameter("chngId", calc.getReqConfig().getChng().getId());
		}
		query.setParameter("lsk", kart.getLsk());
		query.setParameter("period", calc.getReqConfig().getPeriod());
		query.executeUpdate();
		
		long endTime3=System.currentTimeMillis()-beginTime;
		beginTime = System.currentTimeMillis();
		
		//ДЕЛЬТА
		//НАЙТИ и передать дельту в функцию долгов (выполнить только в начислении)
		if (calc.getReqConfig().getOperTp().equals(0)) {
			Set<Control> ctrlSet = new HashSet();
			MapIterator it = mapDeb.mapIterator();
			while (it.hasNext()) {
				it.next();
				MultiKey mk = (MultiKey) it.getKey();
				//log.trace("Проверка дельты: serv="+mk.getKey(0)+" org="+mk.getKey(1)+" sum="+it.getValue(),2);
				BigDecimal val = (BigDecimal)it.getValue();
				if (!(val.compareTo(BigDecimal.ZERO)==0)) {
				//if (lsk.equals("14024244")) {
				  log.info("*** ОТПРАВКА ДЕЛЬТЫ ***: Lsk="+lsk+", serv="+((Serv) mk.getKey(0)).getId()+" org="+((Org) mk.getKey(1)).getId()+" sum="+it.getValue(),2);
				  //проверка на дубли
				  if (ctrlSet.contains(new Control(((Serv) mk.getKey(0)).getId(), ((Org) mk.getKey(1)).getId()))) {
						throw new ErrorWhileChrg("ChrgServ.save: Found dublicate elements while sending delta");
				  }
				  //вызвать хранимую функцию, для пересчёта долга
				  StoredProcedureQuery qr = em.createStoredProcedureQuery("fn.transfer_change");
				  qr.registerStoredProcedureParameter("P_LSK", Integer.class, ParameterMode.IN);
				  qr.registerStoredProcedureParameter("P_FK_SERV", Integer.class, ParameterMode.IN);
				  qr.registerStoredProcedureParameter("P_FK_ORG", Integer.class, ParameterMode.IN);
				  qr.registerStoredProcedureParameter("P_PERIOD", String.class, ParameterMode.IN);
				  qr.registerStoredProcedureParameter("P_SUMMA_CHNG", Double.class, ParameterMode.IN);
				  qr.registerStoredProcedureParameter("P_TP_CHNG", Integer.class, ParameterMode.IN);
				  qr.registerStoredProcedureParameter("P_FK_CHNG", Integer.class, ParameterMode.IN);
				  qr.setParameter("P_LSK", kart.getLsk());
				  qr.setParameter("P_FK_SERV", ((Serv) mk.getKey(0)).getId());
				  qr.setParameter("P_FK_ORG", ((Org) mk.getKey(1)).getId());
				  qr.setParameter("P_PERIOD", calc.getReqConfig().getPeriod());
				  qr.setParameter("P_SUMMA_CHNG", val.doubleValue());
				  qr.setParameter("P_TP_CHNG", 1);
				  qr.setParameter("P_FK_CHNG", 1);
				  
				  qr.execute();
				}
			}
		}
		
		long endTime4=System.currentTimeMillis()-beginTime;
		beginTime = System.currentTimeMillis();
		
		//Сохранить новое начисление (переписать из prepChrg)
		for (Chrg chrg : prepChrg) {
			//log.info("Save услуга="+chrg.getServ().getId()+" объем="+chrg.getVol()+" расценка="+chrg.getPrice()+" сумма="+chrg.getSumFull(),2);
			Chrg chrg2 = new Chrg(kart, chrg.getServ(), chrg.getOrg(), status, calc.getReqConfig().getPeriod(), chrg.getSumFull(), chrg.getSumAmnt(), 
					chrg.getVol(), chrg.getPrice(), chrg.getStdt(), chrg.getCntPers(), chrg.getArea(),  chrg.getTp(), chrg.getDt1(), chrg.getDt2(), 
					calc.getReqConfig().getChng()); 

			kart.getChrg().add(chrg2); 
		}
		
		long endTime5=System.currentTimeMillis()-beginTime;
		
		log.info("TIMING 1={}, 2={}, 3={}, 4={}, 5={}, 6={}", endTime1, endTime2, endTime3, endTime4, endTime5, endTime6);
	}
	
	/**
	 * сохранить запись о сумме, предназаначенной для сохранения дельты в долгах 
	 * @param serv - услуга
	 * @param sum - сумма
	 */
	public /*synchronized */void putSumDeb(MultiKeyMap mkMap, Serv serv, Org org, BigDecimal sum) {
		BigDecimal s = (BigDecimal) mkMap.get(serv, org);
		if (s != null) {
		  s=s.add(sum);
		} else {
		  s = sum;
		}
	    //добавить в элемент массива
		mkMap.put(serv, org, s);
	}


}


