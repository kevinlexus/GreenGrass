package com.ric.bill;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ric.bill.excp.ErrorWhileChrg;
import com.ric.bill.excp.ErrorWhileDist;
import com.ric.bill.mm.HouseMng;
import com.ric.bill.mm.KartMng;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.ar.Kw;
import com.ric.bill.model.bs.Serv;

/**
 * Главный сервис биллинга
 * @author lev
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
@Service
@Scope("prototype")
public class BillServ {

	@Autowired
	private HouseMng houseMng;
	@Autowired
    private DistServ distServ;
	@Autowired
    private DistGen distGen;
	
	@Autowired
    private ChrgServ chrgServ;
	
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
    
	/**
	 * выполнить начисление по всем домам
	 */
/*    @Async
    public Future<Result> chrgAll(boolean dist) {
    	Calc.setDbgLvl(2);
    	
    	Result res = new Result();
		res.err=0;
		long startTime;
		long endTime;
		long totalTime;

		long startTime2;
		long endTime2;
		long totalTime2;

		startTime = System.currentTimeMillis();
		
	    Calc calc=new Calc();

	    if (dist) {
			 distServ.distAll();
		}
		
		for (Kart kart : kartMng.findAll()) {
			//расчитать начисление по лиц.счету
			try {
				startTime2 = System.currentTimeMillis();
		    	//установить дом и счет
				
		    	calc.setHouse(kart.getKw().getHouse());
		    	calc.setKart(kart);
				
				if (chrgServ.chrgLsk(calc) ==0){
					//сохранить расчет
					chrgServ.save(kart.getLsk());
				} else {
					//выполнилось с ошибкой
					//ничего не предпринимать, считать дальше
				}
				endTime2   = System.currentTimeMillis();
				totalTime2 = endTime2 - startTime2;
			    Calc.mess("Time for this one lsk:"+kart.getLsk()+" ="+totalTime2,2);
				
			} catch (ErrorWhileChrg e) {
				//выполнилось с ошибкой, вывести стек
				e.printStackTrace();
			}
			
		}

		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime;
	    Calc.mess("Time for all process:"+totalTime,2);
    	return new AsyncResult<Result>(res);
	}*/
	
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
	 * выполнить начисление по всем домам в потоках
	 */
    @Async
    public Future<Result> chrgAll(boolean dist) {
    	Calc.setDbgLvl(0);
    	
    	Result res = new Result();
		res.err=0;
		long startTime;
		long endTime;
		long totalTime;

		startTime = System.currentTimeMillis();
		

	    if (dist) {
			 distServ.distAll();
		}
	    
		//загрузить все Лиц.счета
		kartThr = kartMng.findAll();
		
	    //флаг ошибки, произошедшей в потоке
	    errThread=false;
	    
		while (true) {
			Calc.mess("BillServ.chrgAll: Loading karts for threads");
			//получить следующие N лиц.счетов, рассчитать их в потоке
			List<Kart> kartWork = getNextKart(1);
			if (kartWork.isEmpty()) {
				//выйти, если все услуги обработаны
				break;
			}

			List<Future<Result>> frl = new ArrayList<Future<Result>>();

			for (Kart kart : kartWork) {
					Calc.mess("BillServ.chrgAll: Prepare thread for lsk="+kart.getLsk());
					Future<Result> fut = null;
					ChrgServ chrgServ = ctx.getBean(ChrgServ.class);

				    Calc calc=new Calc();
				    calc.setKart(kart);
				    calc.setHouse(kart.getKw().getHouse());
				    
				    try {
						fut = chrgServ.chrgLsk(calc);
					} catch (ErrorWhileChrg e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    	frl.add(fut);
					Calc.mess("BillServ.chrgAll: Begins thread for lsk="+kart.getLsk());
			}
			
			
			//проверить окончание всех потоков
		    int flag2 = 0;
			while (flag2==0) {
				Calc.mess("BillServ.chrgAll: Waiting for threads ends");
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
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
				}
			}

		}
		

		
/*		for (Kart kart : kartMng.findAll()) {
			//расчитать начисление по лиц.счету
			try {
				startTime2 = System.currentTimeMillis();
		    	//установить дом и счет
				
		    	calc.setHouse(kart.getKw().getHouse());
		    	calc.setKart(kart);
				
				if (chrgServ.chrgLsk(calc) ==0){
					//сохранить расчет
					chrgServ.save(kart.getLsk());
				} else {
					//выполнилось с ошибкой
					//ничего не предпринимать, считать дальше
				}
				endTime2   = System.currentTimeMillis();
				totalTime2 = endTime2 - startTime2;
			    Calc.mess("Time for this one lsk:"+kart.getLsk()+" ="+totalTime2,2);
				
			} catch (ErrorWhileChrg e) {
				//выполнилось с ошибкой, вывести стек
				e.printStackTrace();
			}
			
		}*/

		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime;
	    Calc.mess("Time for all process:"+totalTime,2);
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
    /*@Async TODO
	public Future<Result> chrgLsk(Kart kart, String lsk, boolean dist) {
		Calc.setDbgLvl(2);
		
    	//ChrgServ chrgServ = (ChrgServ) ctx.getBean("chrgServ"); 
		Result res = new Result();
		Future<Result> fut = new AsyncResult<Result>(res);

		res.err=0;
		//Если был передан идентификатор лицевого, то найти лиц.счет
    	if (lsk != null) {
	    	kart = em.find(Kart.class, lsk);
	    	if (kart ==null) {
	    		res.err=1;
	    		return fut;
	    	}
		}
	    Calc calc=new Calc();
    	
    	//установить дом и счет
    	calc.setHouse(kart.getKw().getHouse());
    	calc.setKart(kart);
    	
		if (dist) {
			try {
				distServ.distKartVol(calc);
			} catch (ErrorWhileDist e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				res.err=1;
				return fut;
			}
		}
		//расчитать начисление
		try {
			if (chrgServ.chrgLsk(calc) ==0){
				//сохранить расчет
				chrgServ.save(kart.getLsk());
			} else {
				res.err=1;
			}
		} catch (ErrorWhileChrg e) {
			e.printStackTrace();
			res.err=1;
		} 
    	return fut;
	}*/

    
    
    
    
    /**
	 * выполнить начисление по дому
	 * @param houseId - Id дома, иначе кэшируется, если передавать объект дома
	 */
/*	public void chrgHouse(int houseId) { TODO
    	ChrgServ chrgServ = (ChrgServ) ctx.getBean("chrgServ"); 

		House h = em.find(House.class, houseId);

		Calc calc=new Calc();

		Calc.mess("Charging");
		Calc.mess("House: id="+calc.getHouse().getId());
		Calc.mess("House: klsk="+calc.getHouse().getKlsk());
		
		//перебрать все квартиры и лиц.счета в них
		for (Kw kw : h.getKw()) {
			for (Kart kart : kw.getLsk()) {
				//if (kart.getLsk().equals("26074227")) {
					long startTime;
					long endTime;
					long totalTime;
					startTime = System.currentTimeMillis();
				    //расчитать начисление
					try {
						if (chrgServ.chrgLsk(calc) ==0){
							//сохранить расчет
							chrgServ.save(kart.getLsk());
						} else {
							//выполнилось с ошибкой
							//ничего не предпринимать, считать дальше
						}
					} catch (ErrorWhileChrg e) {
						e.printStackTrace();
					}

					endTime   = System.currentTimeMillis();
					totalTime = endTime - startTime;
				    Calc.mess("Time for this one lsk:"+kart.getLsk()+" ="+totalTime,2);
					//break; //##################
				//}
			}
			//break; //##################
		}
	}*/


    
}
