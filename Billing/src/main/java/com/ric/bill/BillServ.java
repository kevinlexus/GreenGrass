package com.ric.bill;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
	private Calc calc;
	@Autowired
    private Dist dist;
	@Autowired
	private HouseMng houseMng;
	
	@Test
	public void test1() {
		//для выключения логгинга, просто выкинул из maven всё что касалось log4j
		//распределить объемы по дому
		long startTime;
		long endTime;
		long totalTime;
		
		startTime = System.currentTimeMillis();
		System.out.println("Begin!");
		Calc.setDbgLvl(2);
		dist.gen();
		System.out.println("End!");
			
		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("Время исполнения-1:"+totalTime);

		
	}

	
}
