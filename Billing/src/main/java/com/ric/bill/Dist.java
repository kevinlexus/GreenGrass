package com.ric.bill;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class Dist {

	public static ApplicationContext ctx;
	
	@Autowired
    private BillServ bs;
	
	@Test
	public void test1() {
		//для выключения логгинга, просто выкинул из maven всё что касалось log4j
		// распределить объемы по дому
		System.out.println("Begin!");
		bs.distVols();
		System.out.println("End!");
	}

}
