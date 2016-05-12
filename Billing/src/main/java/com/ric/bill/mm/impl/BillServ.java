package com.ric.bill.mm.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.Dist;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.mm.HouseMng;
import com.ric.bill.model.Dw;
import com.ric.bill.model.House;
import com.ric.bill.model.Kw;
import com.ric.bill.model.Lsk;

/**
 * Главный сервис биллинга
 * @author lev
 *
 */
@Service
public class BillServ {
	static private Date genDt; // рассчитываемая дата

	@Autowired 
    private SessionFactory sessionFactory;

	
	/**
	 * настроить сервис для расчета 
	 */
	@Transactional
	public void setUpServ() {
		Calendar calendar = new GregorianCalendar(2014, Calendar.MARCH, 1);
		BillServ.setGenDt(calendar.getTime());
		
		Session session = sessionFactory.getCurrentSession();
		session.enableFilter("FILTER_GEN_DT").setParameter("DT1", BillServ.getGenDt());
	}
	
	/**
	 * распределить объем по дому
	 */
	@Transactional
	public void distVols() {
		
		
		HouseMng houseMng = (HouseMng)Dist.ctx.getBean("houseMngImpl");
		
		for (House o: houseMng.findAll()) {
		System.out.println("Дом: id="+o.getId());
		System.out.println(getGenDt());
		try {
			System.out.println("Площадь: "+houseMng.getDbl(o.getDw(), "Площадь.Жилая"));
		} catch (WrongGetMethod e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("id="+o.getId()+" klsk="+o.getKlsk());
		System.out.println("тест="+o.getDw());
		for (Dw dw: o.getDw()) {
			System.out.println("Params of house:"+dw.getId()+" "+dw.getS1()+" "+dw.getPar().getName());
		}    		
		
/*		for (Kw kw: o.getKw()) {
			System.out.println("KW="+kw.getId());
			System.out.println("House of the flat:="+kw.getHouse().getId());
			for (Lsk lsk: kw.getLsk()) {
				System.out.println("Lsk of the flat:="+lsk.getFio()+" Lsk="+lsk.getLs());
				lsk.getDw();
				for (Dw dw2: lsk.getDw()) {
		    		System.out.println("Params of lsk:"+dw2.getPar().getName()+" "+dw2.getS1());
					
				}
			}        		
		}    		*/
		break;
		}
	}

	static Date getGenDt() {
		return BillServ.genDt;
	}

	static void setGenDt(Date genDt) {
		BillServ.genDt = genDt;
	}
}
