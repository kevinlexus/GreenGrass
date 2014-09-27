package com.greengrass.house;

//import java.util.List;
import java.util.Date;
import java.util.Set;

import javassist.bytecode.Descriptor.Iterator;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class GreenController {

	
	public static void main(String[] args) {
		System.out.println("Green Grass started!");
		
		Config conf = new Config();
		
		//Hibernate
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		 
		Obj obj = new Obj();
		obj = (Obj) session.bySimpleNaturalId(Obj.class).load("KITCHEN");

		obj.setObjxPropN1ByCd("SWITCHED_ON", 117);
		System.out.println(obj.getObjxPropS1ByCd("SWITCHED_ON"));
		
		
	    session.save(obj);
	 
	    session.getTransaction().commit();
	    
		
		//Hibernate
		
		
		System.out.println("Green Grass ended!");
		
	}

}
