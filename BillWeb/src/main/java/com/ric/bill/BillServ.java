package com.ric.bill;

import java.util.concurrent.Future;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ric.bill.excp.ErrorWhileChrg;
import com.ric.bill.mm.HouseMng;
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
public class BillServ {

	@Autowired
	private HouseMng houseMng;
	@Autowired
	private Calc calc;
	@Autowired
    private DistServ dist;
	@Autowired
    private ChrgServ chrgServ;

    @PersistenceContext
    private EntityManager em;

    private ExecProc ex;

    @Test
	public void test1() {
		
		//распределить объемы по дому
		long startTime;
		long endTime;
		long totalTime;

		System.out.println("Begin!");
		Calc.setDbgLvl(0);

		startTime = System.currentTimeMillis();
		
		//dist.distAll();
		
    	Future<Result> res = null;
    	try {
    		res = chrgAll();
		} catch (ErrorWhileChrg | InterruptedException e) {
			e.printStackTrace();
		}
    	
	   	//проверить окончание потока 
		 while (!res.isDone()) {
	         try {
				Thread.sleep(100);
				//100-millisecond задержка
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	     }

		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("ОБЩЕЕ время исполнения:"+totalTime);

		System.out.println("End!");
			
		
	}


	/**
	 * выполнить начисление по всем домам
	 */
    @Async
    public Future<Result> chrgAll() throws ErrorWhileChrg, InterruptedException {
    	Session sess = (Session) em.getDelegate();
    	ex = new ExecProc(sess);
    	
    	for (House o: houseMng.findAll()) {
			System.out.println("HOUSE:"+o.getId());
			Calc.setInit(false);
			chrgHouse(o.getId());
		}
    	return new AsyncResult<Result>(new Result());
	}
	
    
    /**
	 * выполнить начисление по дому
	 * @param houseId - Id дома, иначе кэшируется, если передавать объект дома
	 */
	public void chrgHouse(int houseId) throws ErrorWhileChrg {

		House h = em.find(House.class, houseId);
		if (!Calc.isInit()) {
			calc.setHouse(h);
			calc.setArea(Calc.getHouse().getStreet().getArea());
			calc.setUp(); //настроить даты фильтра и т.п.
			Calc.setInit(true);
		}
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
					if (chrgServ.chrgLsk(kart) ==0){
						//сохранить расчет
						chrgServ.save(kart.getLsk());
					} else {
						//выполнилось с ошибкой
						return;
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
			chrgServ.chrgLsk(kart);
			//сохранить расчет
			chrgServ.save(kart.getLsk());
		} catch (ErrorWhileChrg e) {
			e.printStackTrace();
			res.err=1;
		}
    	return new AsyncResult<Result>(res);
	}	
}
