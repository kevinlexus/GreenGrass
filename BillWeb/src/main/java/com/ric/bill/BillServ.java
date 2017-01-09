package com.ric.bill;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import com.ric.bill.excp.ErrorWhileChrg;
import com.ric.bill.excp.ErrorWhileDist;
import com.ric.bill.mm.HouseMng;
import com.ric.bill.mm.KartMng;
import com.ric.bill.model.ar.Kart;

/**
 * Главный сервис биллинга
 * @author lev
 *
 */
@ContextConfiguration(locations = { "classpath:spring.xml" })
@Service
@Scope("prototype")
@Slf4j
public class BillServ {

	@Autowired
	private HouseMng houseMng;
	
	@Autowired
    private KartMng kartMng;

	@Autowired
	private ApplicationContext ctx;

    @PersistenceContext
    private EntityManager em;
    
    //коллекция для формирования потоков
    private List<Kart> kartThr;
    
    //конструктор
    public BillServ() {

    }
	
	//получить список N следующих лиц.счетов, для расчета в потоках
    private List<Kart> getNextKart(int cnt) {
    	List<Kart> lst = new ArrayList<Kart>(); 
		int i=1;
		Iterator<Kart> itr = kartThr.iterator();
		while (itr.hasNext()) {
			Kart kart = itr.next(); 
    		lst.add(kart);
    		itr.remove();
    		i++;
			if (i > cnt) {
				break;
			}
		}
		
    	return lst;
	}

    //флаг ошибки, произошедшей в потоке
    private static Boolean errThread;
    
    //Exception из потока
    Thread.UncaughtExceptionHandler expThr = new Thread.UncaughtExceptionHandler() {
        public void uncaughtException(Thread th, Throwable ex) {
			errThread=true;
            System.out.println("BillServ: Error in thread: "+th.getName()+" " + ex.getMessage());
			ex.printStackTrace();
        }
    };
    
    /**
     * выполнить распределение объемов и начисление по всем домам в потоках
     * @param isDist - распределять ли объемы
     * @param isChrg - выполнять ли начисление
     * @return
     */
    @Async
    @CacheEvict(value = { "rrr1", "rrr2", "rrr3" }, allEntries = true)    
    public Future<Result> chrgAll(RequestConfig reqConfig, Integer houseId) {
		//Logger.getLogger("org.hibernate.SQL").setLevel(Level.DEBUG);
		//Logger.getLogger("org.hibernate.type").setLevel(Level.TRACE);
    	
    	Result res = new Result();
		res.err=0;
		// кол-во потоков
		int cntThreads = 10;
		// кол-во обраб.лиц.сч.
		int cntLsk = 0;
		
		long startTime;
		long endTime;
		long totalTime;
		long totalTime3;

		startTime = System.currentTimeMillis();
		DistServ distServ = ctx.getBean(DistServ.class);

	    // РАСПРЕДЕЛЕНИЕ ОБЪЕМОВ
		if (reqConfig.getIsDist()) {
	    	 Calc calc=new Calc(reqConfig);
			 distServ.distAll(calc, houseId);
			 log.info("BillServ.chrgAll: Распределение по всем домам выполнено!");
		}
	    
		// РАСЧЕТ НАЧИСЛЕНИЯ ПО ЛС В ПОТОКАХ
	    if (reqConfig.getOperTp()==0) {
			long startTime3 = System.currentTimeMillis();
			//загрузить все необходимые Лиц.счета
			kartThr = kartMng.findAll(houseId);
			cntLsk = kartThr.size(); 
		    // флаг ошибки, произошедшей в потоке
		    errThread=false;
		    
			while (true) {
				log.info("BillServ.chrgAll: Loading karts for threads");
				// получить следующие N лиц.счетов, рассчитать их в потоке
				long startTime2;
				long endTime2;
				long totalTime2;
				startTime2 = System.currentTimeMillis();
	
				List<Kart> kartWork = getNextKart(cntThreads);
				if (kartWork.isEmpty()) {
					//выйти, если все услуги обработаны
					break;
				}
	
				List<Future<Result>> frl = new ArrayList<Future<Result>>();
	
				for (Kart kart : kartWork) {
	
						log.trace("BillServ.chrgAll: Prepare thread for lsk="+kart.getLsk());
						Future<Result> fut = null;
						ChrgServThr chrgServThr = ctx.getBean(ChrgServThr.class);
	
					    //под каждый поток - свой Calc
						Calc calc=new Calc(reqConfig);
						
					    calc.setKart(kart);
					    calc.setHouse(kart.getKw().getHouse());
					    
					    try {
							fut = chrgServThr.chrgAndSaveLsk(calc);
						} catch (ErrorWhileChrg e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				    	frl.add(fut);
				    	log.trace("BillServ.chrgAll: Begins thread for lsk="+kart.getLsk());
				}
				
				
				// проверить окончание всех потоков
			    int flag2 = 0;
				while (flag2==0) {
					log.trace("BillServ.chrgAll: ========================================== Waiting for threads-2");
					flag2=1;
					for (Future<Result> fut : frl) {
						if (!fut.isDone()) {
							flag2=0;
						} else {
							try {
								log.trace("ChrgServ: Done Result.err:="+fut.get().err);
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
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
				endTime2   = System.currentTimeMillis();
				totalTime2 = endTime2 - startTime2;
				log.info("Time for chrg One Lsk:"+totalTime2/cntThreads,2);
	
			}
			endTime   = System.currentTimeMillis();
			totalTime = endTime - startTime;
			totalTime3 = endTime - startTime3;
			log.info("Ver=2.0",2);
			log.info("Counted lsk:"+cntLsk,2);
			log.info("Time for all process:"+totalTime,2);
		    if (cntLsk > 0) {
		    	log.info("Time per one Lsk: "+totalTime3/cntLsk+" ms.",2);
		    }
	    }
	    
    	return new AsyncResult<Result>(res);
	}
    
	
    
    /**
	 * выполнить начисление по лиц.счету
	 * @param kart - лиц счет (заполнен либо он, либо lsk)
	 * @param lsk - номер лиц.счета 
	 * @param dist - распределить объемы?
	 * @throws InterruptedException 
	 * @throws ErrorWhileChrg
	 */
    @Async
    @CacheEvict(value = { "rrr1", "rrr2", "rrr3" }, allEntries = true)
	public Future<Result> chrgLsk(RequestConfig reqConfig, Kart kart, Integer lsk) {
    	ChrgServThr chrgServThr = ctx.getBean(ChrgServThr.class);
		DistServ distServ = ctx.getBean(DistServ.class);
		
		Result res = new Result();
		Future<Result> fut = new AsyncResult<Result>(res);

		res.err=0;
		// Если был передан идентификатор лицевого, то найти лиц.счет
    	if (lsk != null) {
	    	kart = em.find(Kart.class, lsk);
	    	if (kart ==null) {
	    		res.err=1;
	    		return fut;
	    	}
		}
	    Calc calc=new Calc(reqConfig);
	    
    	// установить дом и счет
    	calc.setHouse(kart.getKw().getHouse());
    	calc.setKart(kart);

    	// РАСПРЕДЕЛЕНИЕ ОБЪЕМОВ, если задано
		if (reqConfig.getIsDist()) {
			try {
				distServ.distKartVol(calc);
			} catch (ErrorWhileDist e) {
				e.printStackTrace();
				res.err=1;
				return fut;
			}
			// присвоить обратно лиц.счет, который мог быть занулён в distServ.distKartVol(calc);
			calc.setKart(kart); 
		}


		// РАСЧЕТ НАЧИСЛЕНИЯ ПО 1 ЛС
	    try {
			fut = chrgServThr.chrgAndSaveLsk(calc);
		} catch (ErrorWhileChrg e) {
			e.printStackTrace();
			res.err=1;
			return fut;
		}
    	return fut;
	}

    
}
