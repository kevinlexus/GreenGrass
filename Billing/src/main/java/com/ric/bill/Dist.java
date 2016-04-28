package com.ric.bill;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mkyong.customer.services.CustomerService;
import com.ric.bill.mm.MeterManager;
import com.ric.bill.model.Meter;


public class Dist {

	public static void main(String[] args) {
		ApplicationContext ctx = 
		        new ClassPathXmlApplicationContext("spring.xml");
        
    	CustomerService cust = (CustomerService)ctx.getBean("customerServiceImpl");
    	System.out.println(cust.sayHello());
    	for (Meter t: cust.showAll()) {
    		System.out.println(t.getId());
    	}

    	MeterManager metManager = (MeterManager)ctx.getBean("meterManagerImpl");
    	for (Meter t: metManager.findAll()) {
    		System.out.println(t.getId());
    	}
    	
    	//		MeterManager metManager = 
          //(MeterManager) ctx.getBean("MeterManagerImpl");
    	
		//ApplicationContext ctx = 
	             //new AnnotationConfigApplicationContext("com.ric.bill"); 		      
        //metManager md = new MeterManagerImpl();
		
		
		//DSess ds = new DSess(false);
		
		//ds.beginTrans();
		//for (Meter t: md.findAll()) {
//			System.out.println(t.getId());
	//	}
		//ds.commitTrans();
		
	}

}
