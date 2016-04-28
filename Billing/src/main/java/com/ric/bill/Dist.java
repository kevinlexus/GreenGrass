package com.ric.bill;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ric.bill.mm.MeterManager;
import com.ric.bill.model.Meter;


public class Dist {

	public static void main(String[] args) {
		ApplicationContext ctx = 
		        new ClassPathXmlApplicationContext("spring.xml");
    	MeterManager metManager = (MeterManager)ctx.getBean("meterManagerImpl");
    	for (Meter t: metManager.findAll()) {
    		System.out.println(t.getId());
    	}
	}

}
