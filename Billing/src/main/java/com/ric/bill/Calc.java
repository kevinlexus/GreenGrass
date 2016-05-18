package com.ric.bill;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.ric.bill.mm.HouseMng;
import com.ric.bill.mm.ServMng;
import com.ric.bill.model.House;
import com.ric.bill.model.Serv;

/**
 * Хранилище всех необходимых параметров для расчета
 * @author lev
 *
 */
public class Calc {
	static private Date genDt; // рассчитываемая дата
	
	private HouseMng houseMng; //менеджер дома
	private ServMng servMng; //менеджер услуги

	private House house; //текущий дом (распределяемый, начисляемый)
	private Serv serv; //текущая услуга (распределяемая, начисляемая)
	
	/**
	 * настроить объект для расчета 
	 */
	public void setUp() {
		Calendar calendar = new GregorianCalendar(2015, Calendar.OCTOBER, 15);
		setGenDt(calendar.getTime());

	}
	
	public static Date getGenDt() {
		return genDt;
	}

	public static void setGenDt(Date genDt) {
		Calc.genDt = genDt;
	}

	public HouseMng getHouseMng() {
		return houseMng;
	}

	public void setHouseMng(HouseMng houseMng) {
		this.houseMng = houseMng;
	}

	public ServMng getServMng() {
		return servMng;
	}

	public void setServMng(ServMng servMng) {
		this.servMng = servMng;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public Serv getServ() {
		return serv;
	}

	public void setServ(Serv serv) {
		this.serv = serv;
	}

	
}
