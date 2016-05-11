package com.ric.bill;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.ric.bill.mm.impl.BillServ;

@Service
public class Dist {

	public static ApplicationContext ctx;
	
	public static void main(String[] args) {
		//для выключения логгинга, просто выкинул из maven всё что касалось log4j
		
		ctx = new ClassPathXmlApplicationContext("spring.xml");
		BillServ bs = (BillServ)Dist.ctx.getBean("billServ");
		// распределить объемы по дому
		bs.distVols();
	}

}
