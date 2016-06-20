package com.ric.bill;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class Dist {

	public static ApplicationContext ctx;
	
	@Autowired
    private BillServ bs;
	
	@Test
	public void test1() {
		//для выключения логгинга, просто выкинул из maven всё что касалось log4j
		//распределить объемы по дому
		long startTime;
		long endTime;
		long totalTime;
		
		startTime = System.currentTimeMillis();
		System.out.println("Begin!");
		Calc.setDbgLvl(0);
		bs.distVols();
		System.out.println("End!");
			
		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("Время исполнения-1:"+totalTime);

		startTime = System.currentTimeMillis();
		System.out.println("Begin!");
		//bs.distVols();
		System.out.println("End!");

		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("Время исполнения-2:"+totalTime);

		startTime = System.currentTimeMillis();
		System.out.println("Begin!");
		//bs.distVols();
		System.out.println("End!");

		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("Время исполнения-3:"+totalTime);
		
	}

}
