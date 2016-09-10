package com.ric.bill;

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
import com.ric.bill.mm.HouseMng;
import com.ric.bill.mm.KartMng;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.ar.Kw;

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
	private Calc calc;
	@Autowired
    private DistServ distServ;
	@Autowired
    private ChrgServ chrgServ;
	
	@Autowired
    private KartMng kartMng;

	@Autowired
	private ApplicationContext ctx;

    @PersistenceContext
    private EntityManager em;

	/**
	 * выполнить начисление по всем домам
	 */
    @Async
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
				
				if (chrgServ.chrgLsk(kart) ==0){
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

		/*for (House o: houseMng.findAll2()) {
			System.out.println("Started House: id="+o.getId());
			Calc.setInit(false);
			chrgHouse(o.getId());
			System.out.println("Finished House: id="+o.getId());
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
    @Async
	public Future<Result> chrgLsk(Kart kart, String lsk, boolean dist) {
		Calc.setDbgLvl(2);
    	
    	//ChrgServ chrgServ = (ChrgServ) ctx.getBean("chrgServ"); 
		Result res = new Result();
		res.err=0;
		//Если был передан идентификатор лицевого, то найти лиц.счет
    	if (lsk != null) {
	    	kart = em.find(Kart.class, lsk);
		}
    	
    	//TEST пока не удалять!
		/*long startTime;
		long endTime;
		long totalTime;
				startTime = System.currentTimeMillis();

		for (int a=1; a < 100; a++) {
	    	for (Kw kw : kart.getKw().getHouse().getKw()) {
	    		Calc.mess("Квартира id="+kw.getId(),2);
	    		for (Kart k : kw.getLsk()) {
	    			for (MLogs ml : k.getMlog()) {
	    	    		Calc.mess("Счетчик id="+ml.getId(),2);
	    				
	    			}
	    			
	    		}
	    		
	    	}
		}
    	
		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime;
	    Calc.mess("TEST time:"+totalTime,2);
    	
		startTime = System.currentTimeMillis();

		for (int a=1; a < 100000; a++) {
		    Calc.mess("Checking",2);
			
		}
    	
		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime;
	    Calc.mess("TEST3 time:"+totalTime,2);

		startTime = System.currentTimeMillis();

		for (int a=1; a < 100000; a++) {
	    	for (Kw kw : kart.getKw().getHouse().getKw()) {
	    		for (Kart k : kw.getLsk()) {
	    			for (MLogs ml : k.getMlog()) {
	    				
	    			}
	    			
	    		}
	    		
	    	}
		}
    	
		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime;
	    Calc.mess("TEST2 time:"+totalTime,2);*/
    	//TEST пока не удалять!
    	
/*
    	//установить дом и счет
    	calc.setHouse(kart.getKw().getHouse());
		calc.setKart(kart);
    	
		if (dist) {
			try {
				distServ.distKartVol(kart.getLsk());
			} catch (ErrorWhileDist e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				res.err=1;
				return new AsyncResult<Result>(res);
			}
		}
		//расчитать начисление
		try {
			if (chrgServ.chrgLsk(kart) ==0){
				//сохранить расчет
				chrgServ.save(kart.getLsk());
			} else {
				res.err=1;
			}
		} catch (ErrorWhileChrg e) {
			e.printStackTrace();
			res.err=1;
		} */
    	return new AsyncResult<Result>(res);
	}

    
    
    
    
    /**
	 * выполнить начисление по дому
	 * @param houseId - Id дома, иначе кэшируется, если передавать объект дома
	 */
	public void chrgHouse(int houseId) {
    	ChrgServ chrgServ = (ChrgServ) ctx.getBean("chrgServ"); 

		House h = em.find(House.class, houseId);

		Calc.mess("Charging");
		Calc.mess("House: id="+Calc.getHouse().getId());
		Calc.mess("House: klsk="+Calc.getHouse().getKlsk());
		
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
						if (chrgServ.chrgLsk(kart) ==0){
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
	}

    
}
