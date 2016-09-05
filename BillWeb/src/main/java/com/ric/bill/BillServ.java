package com.ric.bill;

import java.util.concurrent.Future;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

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
//@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
@Scope("prototype")
public class BillServ {

	@Autowired
	private HouseMng houseMng;
	@Autowired
	private Calc calc;
	@Autowired
    private DistServ dist;
	@Autowired
    private ChrgServ chrgServ;
	@Autowired
    private KartMng kartMng;

	@Autowired
    private Check check;

	@PersistenceContext
    private EntityManager em;

    @Async
    public Future<Result> useCheck() {
		Result res = new Result();

		System.out.println("Try-1");

    	check.checkMe(1);

    	res.err=0;
		return new AsyncResult<Result>(res);
    }
    
	/**
	 * выполнить начисление по всем домам
	 */
    @Async
    public Future<Result> chrgAll() {
		Result res = new Result();
		res.err=0;
		long startTime;
		long endTime;
		long totalTime;

		long startTime2;
		long endTime2;
		long totalTime2;

		startTime = System.currentTimeMillis();
		//установить даты
		calc.setUp();
		
		System.out.println("chrgAll 1");
		for (Kart kart : kartMng.findAll()) {
			//расчитать начисление по лиц.счету
			
			
			//check.checkMe(1);
			
			try {
				startTime2 = System.currentTimeMillis();
				
				System.out.println("chrgAll 2 "+kart.getLsk());
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
	 * @param kart
	 * @throws InterruptedException 
	 * @throws ErrorWhileChrg
	 */
    @Async
	public Future<Result> chrgLsk(Kart kart, String lsk) {
		Result res = new Result();
		res.err=0;
		//Если был передан идентификатор лицевого, то найти лиц.счет
    	if (lsk != null) {
	    	kart = em.find(Kart.class, lsk);
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
		}
    	return new AsyncResult<Result>(res);
	}

    
    
    
    
    /**
	 * выполнить начисление по дому
	 * @param houseId - Id дома, иначе кэшируется, если передавать объект дома
	 */
	public void chrgHouse(int houseId) {

		House h = em.find(House.class, houseId);
		if (!Calc.isInit()) {
			calc.setUp(); //настроить даты фильтра и т.п.
			Calc.setInit(true);
		}
		calc.setHouse(h);
		calc.setArea(Calc.getHouse().getStreet().getArea());

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
