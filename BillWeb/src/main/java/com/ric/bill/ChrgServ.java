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

import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
import com.ric.bill.model.bs.Org;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.fn.Chrg;

/**
 * Сервис формирования начисления
 * @author lev
 *
 */
@Service
@Scope("prototype")
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
    
    //конструктор
    public ChrgServ() {
    	super();
    }

    //Exception из потока
    Thread.UncaughtExceptionHandler expThr = new Thread.UncaughtExceptionHandler() {
        public void uncaughtException(Thread th, Throwable ex) {
			errThread=true;
            System.out.println("ChrgServ: Error in thread: "+th.getName()+" " + ex.getMessage());
			ex.printStackTrace();
        }
    };
    
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
	public int chrgLsk(Calc calc) throws ErrorWhileChrg {
		Calc.mess("ChrgServ.chrgLsk Lsk="+calc.getKart().getLsk(), 2);

		prepChrg = new ArrayList<Chrg>(0); 
		//получить все необходимые услуги для начисления из тарифа по дому

		//для виртуальной услуги	
		mapServ = new HashMap<Serv, BigDecimal>();  
		mapVrt = new HashMap<Serv, BigDecimal>();  

		//список потоков
		List<ChrgThr> trl = new ArrayList<ChrgThr>();
		//найти все услуги, действительные в лиц.счете
		//и создать потоки по кол-ву услуг
		
		Kart kart = calc.getKart();
		//загрузить все услуги
		servThr = kartMng.getAllServ(kart);
		
		errThread=false;
		List<Future<Result>> frl = new ArrayList<Future<Result>>();

		while (true) {
			Calc.mess("ChrgServ: Loading servs for threads");
			//получить следующие N услуг, рассчитать их в потоке
			List<Serv> servWork = getNextServ(10);
			if (servWork.isEmpty()) {
				//выйти, если все услуги обработаны
				break;
			}
			for (Serv serv : servWork) {
					Future<Result> fut = null;
					ChrgThr chrgThr = ctx.getBean(ChrgThr.class);
 					chrgThr.set(calc, serv, kart, mapServ, mapVrt, prepChrg);
			    	fut = chrgThr.run1();
			    	frl.add(fut);
					Calc.mess("ChrgServ: Begins "+serv.getCd());

			}
		}
		
		
		//проверить окончание потока
	    int flag2 = 0;
		while (flag2==0) {
			flag2=1;
			for (Future<Result> fut : frl) {
				if (!fut.isDone()) {
					flag2=0;
				} else {
					try {
						Calc.mess("ChrgServ: Done Result.err:="+fut.get().err);
						if (fut.get().err==1) {
							errThread=true;
						}
					} catch (InterruptedException | ExecutionException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		}
					/*
					
					ChrgThr thr1 = (ChrgThr) ctx.getBean(ChrgThr.class);
					thr1.set(serv, kart, mapServ, mapVrt, prepChrg);
					thr1.start();
					thr1.setUncaughtExceptionHandler(expThr);
					trl.add(thr1);*/
			//ждать, когда все потоки выполнятся
		/*	for (ChrgThr t : trl) {
				try {
					t.join();
					//Calc.mess("WAIT="+t.getName(), 2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					throw new ErrorWhileChrg("ChrgServ.chrgLsk: ChrgThr: ErrorWhileChrg in thread!");
				} 
			}
			if (errThread) {
				//была ошибка в потоке- выйти из цикла
				break;
			}
		}*/

		
		
		//Calc.mess("*******************ALL THREADS FINISHED!********************", 2);

		//если была ошибка в потоке - приостановить выполнение, выйти
		if (errThread) {
			Calc.mess("ChrgServ.chrgLsk: Error in thread, exiting!", 2);
			return 1;
		}
		//Calc.mess("CHECK6",2);	
		
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
								/*if (kart.getLsk().equals("26074227")) {
									Calc.mess("Коррекция услуги="+chrg.getServ().getId()+" на сумму="+diff,2);
								}*/
								flag = true;
								chrg.setSumAmnt(BigDecimal.valueOf(chrg.getSumAmnt()).add(diff).doubleValue()) ;
								chrg.setSumFull(BigDecimal.valueOf(chrg.getSumFull()).add(diff).doubleValue()) ;
							}
						}
					}
				}
			}		    
		}		
		
		//Calc.mess("CHECK7",2);	
		return 0;
	}



	/**
	 * перенести в архив предыдущее и сохранить новое начисление
	 * @param lsk - лиц.счет передавать строкой!
	 * @throws ErrorWhileChrg 
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void save (String lsk) throws ErrorWhileChrg {
		
	    //коллекция для сумм по укрупнённым услугам, для нового начисления 
	    MultiKeyMap mapDeb = new MultiKeyMap();

	    //Calc.mess("CHECK9",2);	
		Kart kart = em.find(Kart.class, lsk); //здесь так, иначе записи не прикрепятся к объекту не из этой сессии!
		
		//ДЕЛЬТА
		//ПОДГОТОВИТЬСЯ для сохранения дельты
		//сгруппировать до укрупнённых услуг текущий расчет по debt
		for (Chrg chrg : prepChrg) { 
			Serv servMain = null;
			try {
				servMain = servMng.getUpper(chrg.getServ(), "serv_tree_kassa");
			}catch(Exception e) {
				//servMain = chrg.getServ();
			    e.printStackTrace();
				throw new ErrorWhileChrg("ChrgServ.save: ChrgThr: ErrorWhileChrg");
			}
			//получить организацию из текущей сессии, по ID, так как орг. из запроса будет иметь другой идентификатор
			Org orgMain = em.find(Org.class, chrg.getOrg().getId());
			//Сохранить сумму по укрупнённой услуге, для расчета дельты для debt
			putSumDeb(mapDeb, servMain, orgMain, BigDecimal.valueOf(chrg.getSumAmnt()));
			//Calc.mess("Сохранить дельту: serv="+servMain.getId()+" org="+chrg.getOrg().getId()+" sum="+BigDecimal.valueOf(chrg.getSumAmnt()),2);
		}

		//сгруппировать до укрупнённых услуг предыдущий расчет по debt
		for (Chrg chrg : kart.getChrg()) {
			//Только необходимые строки
			//Calc.mess("CHECK status="+chrg.getStatus()+"period="+chrg.getPeriod(), 2);
			if (chrg.getStatus()==1 && chrg.getPeriod().equals(config.getPeriod())) {
				Serv servMain = null;
				try {
					servMain = servMng.getUpper(chrg.getServ(), "serv_tree_kassa");
				}catch(Exception e) {
				    //e.printStackTrace();
					servMain = chrg.getServ();
					//throw new ErrorWhileChrg("ChrgServ.save: ChrgThr: ErrorWhileChrg");
				}
				//получить организацию из текущей сессии, по ID, так как орг. из запроса будет иметь другой идентификатор
				Org orgMain = em.find(Org.class, chrg.getOrg().getId());
				//Вычесть сумму по укрупнённой услуге из нового начисления, для расчета дельты для debt
				//Calc.mess("Вычесть дельту: serv="+servMain.getId()+" org="+chrg.getOrg().getId()+" sum="+BigDecimal.valueOf(-1d * chrg.getSumAmnt()),2);
				putSumDeb(mapDeb, servMain, orgMain, BigDecimal.valueOf(-1d * Utl.nvl(chrg.getSumAmnt(), 0d)));
			}
		}
		
		//перенести предыдущий расчет начисления в статус "архив" (1->0)
		Query query = em.createQuery("update Chrg t set t.status=0 where t.lsk=:lsk "
				+ "and t.status=1 "
				//+ "and t.dt1 between :dt1 and :dt2 " -нет смысла, есть period
				//+ "and t.dt2 between :dt1 and :dt2 "
				+ "and t.period=:period"
				);
		query.setParameter("lsk", kart.getLsk());
		//query.setParameter("dt1", Calc.getCurDt1());
		//query.setParameter("dt2", Calc.getCurDt2());
		query.setParameter("period", config.getPeriod());
		query.executeUpdate();
		
		//ДЕЛЬТА
		//НАЙТИ и передать дельту в функцию долгов
		MapIterator it = mapDeb.mapIterator();
		while (it.hasNext()) {
			it.next();
			MultiKey mk = (MultiKey) it.getKey();
			//Calc.mess("Проверка дельты: serv="+mk.getKey(0)+" org="+mk.getKey(1)+" sum="+it.getValue(),2);
			BigDecimal val = (BigDecimal)it.getValue();
			if (!(val.compareTo(BigDecimal.ZERO)==0)) {

			  try {
				Calc.mess("Отправка дельты: serv="+((Serv) mk.getKey(0)).getId()+" org="+((Org) mk.getKey(1)).getId()+" sum="+it.getValue(),2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//Calc.mess("Проверка дельты1: serv="+mk.getKey(0)+" org="+mk.getKey(1)+" sum="+it.getValue(),2);
				//Calc.mess("Проверка дельты2: org="+((Org) mk.getKey(1)).getId()+" sum="+it.getValue(),2);
				//Calc.mess("Проверка дельты2: serv="+((Serv) mk.getKey(0)).getId()+" sum="+it.getValue(),2);
				e.printStackTrace();
				
			}
			  
			  //вызвать хранимую функцию, для пересчёта долга
			  StoredProcedureQuery qr = em.createStoredProcedureQuery("fn.transfer_change");
			  qr.registerStoredProcedureParameter("P_LSK", String.class, ParameterMode.IN);
			  qr.registerStoredProcedureParameter("P_FK_SERV", Integer.class, ParameterMode.IN);
			  qr.registerStoredProcedureParameter("P_FK_ORG", Integer.class, ParameterMode.IN);
			  qr.registerStoredProcedureParameter("P_PERIOD", String.class, ParameterMode.IN);
			  qr.registerStoredProcedureParameter("P_SUMMA_CHNG", Double.class, ParameterMode.IN);
			  //qr.registerStoredProcedureParameter("P_DTEK", Date.class, ParameterMode.IN);
			  qr.registerStoredProcedureParameter("P_TP_CHNG", Integer.class, ParameterMode.IN);
			  qr.registerStoredProcedureParameter("P_FK_CHNG", Integer.class, ParameterMode.IN);
			  qr.setParameter("P_LSK", kart.getLsk());
			  qr.setParameter("P_FK_SERV", ((Serv) mk.getKey(0)).getId());
			  qr.setParameter("P_FK_ORG", ((Org) mk.getKey(1)).getId());
			  qr.setParameter("P_PERIOD", config.getPeriod());
			  qr.setParameter("P_SUMMA_CHNG", val.doubleValue());
			  //qr.setParameter("P_DTEK", new Date());
			  qr.setParameter("P_TP_CHNG", 1);
			  qr.setParameter("P_FK_CHNG", 1);
			  
			  qr.execute();
			}
		}
		
		//Сохранить новое начисление
		for (Chrg chrg : prepChrg) {
			//Calc.mess("Save услуга="+chrg.getServ().getId()+" объем="+chrg.getVol()+" расценка="+chrg.getPrice()+" сумма="+chrg.getSumFull(),2);
			Chrg chrg2 = new Chrg(kart, chrg.getServ(), chrg.getOrg(), 1, config.getPeriod(), chrg.getSumAmnt(), chrg.getSumFull(), 
					chrg.getVol(), chrg.getPrice(), chrg.getTp(), chrg.getDt1(), chrg.getDt2()); 
			kart.getChrg().add(chrg2); 
		}
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


