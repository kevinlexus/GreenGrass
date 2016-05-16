package com.ric.bill.mm.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.Dist;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.mm.HouseMng;
import com.ric.bill.model.Dw;
import com.ric.bill.model.House;
import com.ric.bill.model.Meter;
import com.ric.bill.model.MeterExs;
import com.ric.bill.model.MeterLog;
import com.ric.bill.model.MeterLogGraph;
import com.ric.bill.model.Vol;

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
	public void setUpServ() {
		Calendar calendar = new GregorianCalendar(2015, Calendar.OCTOBER, 15);
		BillServ.setGenDt(calendar.getTime());

	}
	
	/**
	 * Установить фильтры для сессии
	 */
	@Transactional(propagation=Propagation.MANDATORY)
	public void setFilters() {
		Session session = sessionFactory.getCurrentSession();
		session.enableFilter("FILTER_GEN_DT").setParameter("DT1", BillServ.getGenDt());
	}

	/**
	 * распределить объем по дому
	 */
	@Transactional
	public void distVols() {
		
		setFilters();// вкл.фильтр
		
		HouseMng houseMng = (HouseMng)Dist.ctx.getBean("houseMngImpl");
		
		for (House o: houseMng.findAll()) {
		System.out.println("Дом: id="+o.getId());
		System.out.println("Дом: klsk="+o.getKlsk());
		System.out.println(getGenDt());
		try {
			System.out.println("Площадь: "+houseMng.getDbl(o.getDw(), "Площадь.Жилая"));
		} catch (WrongGetMethod e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (MeterLog mLog: o.getMlog()) {
			System.out.println("лог счетчик: "+mLog.getName()+" id="+mLog.getId() );
			System.out.println("лог счетчик :тип="+mLog.getTp().getCd());
			for (Vol v: mLog.getVol()) {
				System.out.println("лог счетчик:объем="+v.getVol1());
			}
			
			for (MeterLogGraph g: mLog.getDst()) {
				System.out.println("лог счетчик:связь входящая="+g.getId()+" "+g.getTp().getName());
			}
			for (MeterLogGraph g: mLog.getSrc()) {
				System.out.println("лог счетчик:связь исходящая="+g.getId()+" "+g.getTp().getName());
			}

			for (Meter m: mLog.getMeter()) {
				System.out.println("физ счетчик: id="+m.getId());
				for (MeterExs e: m.getExs()) {
					System.out.println("физ счетчик: существование="+e.getPrc());
				}
				for (Vol v: m.getVol()) {
					System.out.println("физ счетчик:объем="+v.getVol1());
				}
			}
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
