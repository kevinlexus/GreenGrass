package com.ric.bill;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.excp.ErrorWhileChrg;
import com.ric.bill.mm.HouseMng;
import com.ric.bill.mm.KartMng;
import com.ric.bill.mm.LstMng;
import com.ric.bill.mm.MeterLogMng;
import com.ric.bill.mm.ParMng;
import com.ric.bill.mm.ServMng;
import com.ric.bill.mm.TarifMng;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.ar.Kw;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.fn.Chrg;
import com.ric.bill.model.fn.ChrgStore;

/**
 * Сервис формирования начисления
 * @author lev
 *
 */
@Service
public class ChrgServ {

	@Autowired
	private Calc calc;
	@Autowired
	private ParMng parMng;
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

    //вспомогательные массивы
    private List<Chrg> prepChrg;
    private HashMap<Serv, BigDecimal> mapServ;
    private HashMap<Serv, BigDecimal> mapVrt;
    
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
            
        }
    };
    
	/**
	 * выполнить расчет начисления по лиц.счету
	 * @param kart - объект лиц.счета
	 * @throws ErrorWhileChrg 
	 */
	public int chrgLsk(Kart kart) throws ErrorWhileChrg {
		Calc.mess("ЛС===:"+kart.getLsk());
		if (!Calc.isInit()) {
			calc.setHouse(kart.getKw().getHouse());
			calc.setArea(kart.getKw().getHouse().getStreet().getArea());
			calc.setUp(); //настроить даты фильтра и т.п.
			Calc.setInit(true);
		}
		calc.setKart(kart);

		prepChrg = new ArrayList<Chrg>(0); 
		//получить все необходимые услуги для начисления из тарифа по дому

		//для виртуальной услуги	
		mapServ = new HashMap<Serv, BigDecimal>();  
		mapVrt = new HashMap<Serv, BigDecimal>();  

		//список потоков
		List<ChrgThr> trl = new ArrayList<ChrgThr>();
		//найти все услуги, действительные в лиц.счете
		//и создать потоки по кол-ву услуг
		
		for (Serv serv : kartMng.getAllServ(kart)) {
				ChrgThr thr1 = (ChrgThr) ctx.getBean(ChrgThr.class);
				thr1.set(serv, kart);
				thr1.start();
				thr1.setUncaughtExceptionHandler(expThr);
				trl.add(thr1);
				Calc.mess("START="+thr1.getName(), 2);
		    //	break; //TODO - временно выход!
		}

		errThread=false;
		
		//ждать, когда все потоки выполнятся
		for (ChrgThr t : trl) {
			try {
				t.join();
				Calc.mess("WAIT="+t.getName(), 2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				throw new ErrorWhileChrg("ChrgServ.chrgLsk: ChrgThr: ErrorWhileChrg in thread!");
			} 
		}
		
		Calc.mess("*******************ALL THREADS FINISHED!********************", 2);

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
	 * сохранить запись о сумме предназаначенной для коррекции 
	 * @param serv - услуга
	 * @param sum - сумма
	 */
	public synchronized void putMapServVal(Serv serv, BigDecimal sum) {
		BigDecimal tmpSum;
		//HaspMap считает разными услуги, если они одинаковые, но пришли из разных потоков, пришлось искать for - ом
		for (Map.Entry<Serv, BigDecimal> entry : mapServ.entrySet()) {
	    	if (entry.getKey().equals(serv)) { 
	    		tmpSum = Utl.nvl(entry.getValue(), BigDecimal.ZERO);
	    		tmpSum = tmpSum.add(sum);
	    		//Calc.mess("Write serv id="+serv.getId()+" val="+sum,2);
	    	    mapServ.put(entry.getKey(), tmpSum);
	    		return;
	    	}
	    }
	    mapServ.put(serv, sum);
	}
	
	/**
	 * сохранить запись о сумме предназаначенной для коррекции 
	 * @param serv - услуга
	 * @param sum - сумма
	 */
	public synchronized void putMapVrtVal(Serv serv, BigDecimal sum) {
		BigDecimal tmpSum;
		//HaspMap считает разными услуги, если они одинаковые, но пришли из разных потоков, пришлось искать for - ом
	    for (Map.Entry<Serv, BigDecimal> entry : mapVrt.entrySet()) {
	    	if (entry.getKey().equals(serv)) {
	    		tmpSum = Utl.nvl(entry.getValue(), BigDecimal.ZERO);
	    		tmpSum = tmpSum.add(sum);
	    		mapVrt.put(entry.getKey(), tmpSum);
	    		return;
	    	}
	    }
	    mapVrt.put(serv, sum);
	}

	/**
	 * перенести в архив предыдущее и сохранить новое начисление
	 * @param lsk - лиц.счет передавать строкой!
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void save (String lsk) {
		//Session sess = (Session)em.getDelegate();
		////Calc.mess("CHECK8.1="+sess,2);	
		//sess.clear();
		
		//Calc.mess("CHECK9",2);	
		Kart kart = em.find(Kart.class, lsk); //здесь так, иначе записи не прикрепятся к объекту не из этой сессии!
		if (!Calc.isInit()) {
			calc.setHouse(kart.getKw().getHouse());
			calc.setArea(kart.getKw().getHouse().getStreet().getArea());
			calc.setUp(); //настроить даты фильтра и т.п.
			Calc.setInit(true);
		}
		//Calc.mess("CHECK10",2);	

		//Calc.mess("UPDATE:"+kart.getLsk()+" period="+Calc.getPeriod(), 2);
		//перенести предыдущий расчет начисления в статус "подготовка к архиву" (1->2)
		Query query = em.createQuery("update Chrg t set t.status=2 where t.lsk=:lsk "
				+ "and t.status=1 "
				+ "and t.dt1 between :dt1 and :dt2 "
				+ "and t.dt2 between :dt1 and :dt2 "
				+ "and t.period=:period"
				);
		query.setParameter("lsk", kart.getLsk());
		query.setParameter("dt1", Calc.getCurDt1());
		query.setParameter("dt2", Calc.getCurDt2());
		query.setParameter("period", Calc.getPeriod());
		query.executeUpdate();

		//Calc.mess("CHECK11",2);	
		for (Chrg chrg : prepChrg) {
			//Calc.mess("Save услуга="+chrg.getServ().getId()+" объем="+chrg.getVol()+" расценка="+chrg.getPrice()+" сумма="+chrg.getSumFull(),2);
			Chrg chrg2 = new Chrg(kart, chrg.getServ(), chrg.getOrg(), 1, Calc.getPeriod(), chrg.getSumAmnt(), chrg.getSumFull(), 
					chrg.getVol(), chrg.getPrice(), chrg.getTp(), chrg.getDt1(), chrg.getDt2()); 
			kart.getChrg().add(chrg2); 

		}
		//Calc.mess("CHECK12",2);	
		
	}
	
	/**
	 * добавить из потока строку начисления 
	 * @param chrg - строка начисления
	 */
	public synchronized void chrgAdd(Chrg chrg) {
		prepChrg.add(chrg);

	}
}


