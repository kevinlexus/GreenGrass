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
		
		//ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//распределить объемы по дому
		long startTime;
		long endTime;
		long totalTime;

		System.out.println("Begin!");
		Calc.setDbgLvl(0);

		/*Logger.getRootLogger().setLevel(Level.ERROR);
		Logger.getLogger("org.hibernate.SQL").setLevel(Level.DEBUG);
		Logger.getLogger("org.hibernate.type").setLevel(Level.TRACE);
		*/
		/*Logger.getRootLogger().setLevel(Level.OFF);
		Logger.getLogger("org.hibernate.SQL").setLevel(Level.OFF);
		Logger.getLogger("org.hibernate.type").setLevel(Level.OFF);
		*/

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
	 * начислить по всем домам
	 */
	//@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
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
	//@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
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
		int aaa=1;
		for (Kw kw : h.getKw()) {
			for (Kart kart : kw.getLsk()) {
				aaa++;
				if (aaa > 5) {
					//break;
				}
				/*for (MeterLog mLog: kart.getMlog()) {
					Calc.mess("сч="+mLog.getId());
					//Calc.mess("Дом в сч.: klsk="+mLog.getHouse().getKlsk());
				}*/ 

				//if (kart.getLsk().equals("26074101")) {
					long startTime3;
					long endTime3;
					long totalTime3;
					startTime3 = System.currentTimeMillis();
				    //Calc.mess("Расчет лиц счета:"+kart.getLsk(),2);
				    
				    //расчитать начисление
					chrgServ.chrgLsk(kart);
					//сохранить расчет
					chrgServ.save(kart.getLsk());

					endTime3   = System.currentTimeMillis();
					totalTime3 = endTime3 - startTime3;
				    Calc.mess("ВРЕМЯ НАЧИСЛЕНИЯ по лиц счету:"+kart.getLsk()+" ="+totalTime3,2);
					//break; //##################
				//}
				//Calc.mess("Кол-во записей="+ex.runWork(1, 0, 0),2);
			}
			//break; //##################
		}
	}
    
	
}
