package com.ric.bill;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
		
		try {
			chrgAll();
		} catch (ErrorWhileChrg e) {
			e.printStackTrace();
		}

		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("ОБЩЕЕ время исполнения:"+totalTime);

		System.out.println("End!");
			
		
	}


	/**
	 * выполнить начисление по всем домам
	 */
    public void chrgAll()  throws ErrorWhileChrg {
    	Session sess = (Session) em.getDelegate();
    	ex = new ExecProc(sess);
    	
    	for (House o: houseMng.findAll()) {
			System.out.println("ДОМ:"+o.getId());
			Calc.setInit(false);
			chrgHouse(o.getId());
		}
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
		Calc.mess("Начисление");
		Calc.mess("Дом: id="+Calc.getHouse().getId());
		Calc.mess("Дом: klsk="+Calc.getHouse().getKlsk());
		
		//перебрать все квартиры и лиц.счета в них
		for (Kw kw : h.getKw()) {
			for (Kart kart : kw.getLsk()) {
				//if (kart.getLsk().equals("26074101")) {
					long startTime;
					long endTime;
					long totalTime;
					startTime = System.currentTimeMillis();
				    //расчитать начисление
					chrgServ.chrgLsk(kart);
					//сохранить расчет
					chrgServ.save(kart.getLsk());

					endTime   = System.currentTimeMillis();
					totalTime = endTime - startTime;
				    Calc.mess("ВРЕМЯ НАЧИСЛЕНИЯ по лиц счету:"+kart.getLsk()+" ="+totalTime,2);
					//break; //##################
			}
			//break; //##################
		}
	}

	/**
	 * выполнить начисление по лиц.счету
	 * @param kart
	 * @throws ErrorWhileChrg
	 */
	public void chrgLsk(Kart kart) throws ErrorWhileChrg {
	    //расчитать начисление
		chrgServ.chrgLsk(kart);
		//сохранить расчет
		chrgServ.save(kart.getLsk());
	}	
}
