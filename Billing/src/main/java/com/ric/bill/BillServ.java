package com.ric.bill;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ric.bill.excp.ErrorWhileChrg;
import com.ric.bill.mm.HouseMng;

/**
 * Главный сервис биллинга
 * @author lev
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class BillServ {

	public static ApplicationContext ctx;
	
	@Autowired
	private HouseMng houseMng;
	@Autowired
	private Calc calc;
	@Autowired
    private DistServ dist;
	@Autowired
    private ChrgServ chrg;

	@Test
	public void test1() {
		//распределить объемы по дому
		//long startTime;
		long startTime2;
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

		startTime2 = System.currentTimeMillis();
		/*try {
			for (House o: houseMng.findAll()) {
				System.out.println("ДОМ:"+o.getId());
				//dist.clearCache();
				//распределить объемы
				startTime = System.currentTimeMillis();
				Calc.setInit(false);
				
				dist.distHouseVol(o.getId());
				//System.out.println("------------------------------------------");
				//dist.distHouseVol(o.getId());

				//передать по ID иначе кэшируется
				endTime   = System.currentTimeMillis();
				totalTime = endTime - startTime;
				System.out.println("Время исполнения-1:"+totalTime);
				
				//Logger.getLogger("org.hibernate.SQL").setLevel(Level.DEBUG);
				//Logger.getLogger("org.hibernate.type").setLevel(Level.TRACE);
				
				startTime = System.currentTimeMillis();
			    //начисление
				//chrg.chrgHouse(o.getId()); //передать по ID иначе кэшируется
				endTime   = System.currentTimeMillis();
				totalTime = endTime - startTime;
				System.out.println("Время исполнения-3:"+totalTime);
				
			}
		} catch (ErrorWhileDist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//dist.distAll();
		
		try {
			chrg.chrgAll();
		} catch (ErrorWhileChrg e) {
			e.printStackTrace();
		}
		
		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime2;
		System.out.println("ОБЩЕЕ время исполнения:"+totalTime);

		System.out.println("End!");
			
		
	}

	
	
}
