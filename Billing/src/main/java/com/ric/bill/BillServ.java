package com.ric.bill;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ric.bill.mm.HouseMng;
import com.ric.bill.model.ar.House;

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
    private Dist dist;
	@Autowired
    private ChrgServ chrg;
	
	@Test
	public void test1() {
		//для выключения логгинга, просто выкинул из maven всё что касалось log4j
		//распределить объемы по дому
		long startTime;
		long endTime;
		long totalTime;
		
		System.out.println("Begin!");
		Calc.setDbgLvl(0);

		//Logger.getRootLogger().setLevel(Level.ERROR);
		//Logger.getLogger("org.hibernate.SQL").setLevel(Level.DEBUG);
		
		for (House o: houseMng.findAll()) {
			System.out.println("ДОМ:"+o.getId());
			dist.clearCache();
			//распределить объемы
			startTime = System.currentTimeMillis();
			dist.distHouseVol(o.getId()); //передать по ID иначе кэшируется
			endTime   = System.currentTimeMillis();
			totalTime = endTime - startTime;
			System.out.println("Время исполнения-1:"+totalTime);
			
			//распределить объемы
			/*startTime = System.currentTimeMillis();
			dist.distHouseVol(o.getId()); //передать по ID иначе кэшируется
			endTime   = System.currentTimeMillis();
			totalTime = endTime - startTime;
			System.out.println("Время исполнения-2:"+totalTime);*/
			
			startTime = System.currentTimeMillis();
		    //начисление
			//chrg.chrgHouse(o.getId()); //передать по ID иначе кэшируется
			endTime   = System.currentTimeMillis();
			totalTime = endTime - startTime;
			System.out.println("Время исполнения-3:"+totalTime);
			
		}

		System.out.println("End!");
			
		
	}

	
	
}
