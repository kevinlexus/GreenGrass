package com.ric.bill;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ric.bill.mm.HouseMng;
import com.ric.bill.model.Dw;
import com.ric.bill.model.Dw2;
import com.ric.bill.model.House;
import com.ric.bill.model.House2;


public class Dist {

	public static void main(String[] args) {
		
		/*		Session sess=HibernateUtil.getSessionFactory().openSession();
		sess.beginTransaction();
		House2 h = (House2) sess.get(House2.class, 965);

		System.out.println("House2="+h.getId());
		
    	for (Dw2 dw: h.getDw2()) {
    		System.out.println("свойство="+dw.getId()+" "+dw.getS1());
    	}*/
		
		ApplicationContext ctx =  
		        new ClassPathXmlApplicationContext("spring.xml");
		
		/*MeterMng metManager = (MeterMng)ctx.getBean("meterManagerImpl");
    	for (Storable o: metManager.findAll()) {
    		System.out.println("id="+o.getId()+" klsk="+o.getKlsk());
    	}*/

		HouseMng houseMng = (HouseMng)ctx.getBean("houseMngImpl");
    	for (House o: houseMng.findAll()) {
    		System.out.println("id="+o.getId()+" klsk="+o.getKlsk());
    		System.out.println("тест="+o.getDw());
        	for (Dw dw: o.getDw()) {
        		System.out.println("свойство="+dw.getId()+" "+dw.getS1()+" "+dw.getPar().getName());
        	}    		
        	break;
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
