package com.ric.bill;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ric.bill.mm.MeterManager;
import com.ric.bill.model.House;
import com.ric.bill.model.Lsk;
import com.ric.bill.model.Meter;
import com.ric.bill.model.Storable;


public class Dist {

	public static void main(String[] args) {
		
		Storable o;
		
		ApplicationContext ctx = 
		        new ClassPathXmlApplicationContext("spring.xml");
		
    	MeterManager metManager = (MeterManager)ctx.getBean("meterManagerImpl");
    	for (Meter t: metManager.findAll()) {
    		System.out.println("id="+t.getId()+" klsk="+t.getKlsk());
    	}

    	
		/*
		 * 
		 * НЕ УДАЛЯТЬ!!!!
		ApplicationContext ctx = 
		        new ClassPathXmlApplicationContext("spring.xml");
    	MeterManager metManager = (MeterManager)ctx.getBean("meterManagerImpl");
    	for (Meter t: metManager.findAll()) {
    		System.out.println(t.getId());
    	}
    	
    	*/
	}

}
