package com.ric.bill;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ric.bill.mm.HouseMng;
import com.ric.bill.mm.MeterLogMng;
import com.ric.bill.mm.ServMng;
import com.ric.bill.model.Area;
import com.ric.bill.model.House;
import com.ric.bill.model.Serv;

/**
 * Хранилище всех необходимых параметров для расчета
 * @author lev
 *
 */
@Service
public final class Calc {
	private static Date genDt; // рассчитываемая дата
	// даты текущего периода
	private static Date curDt1;
	private static Date curDt2;
	
	@Autowired
	private HouseMng houseMng; //менеджер дома
	@Autowired
	private ServMng servMng; //менеджер услуги
	@Autowired
	private MeterLogMng metLogMng; //менеджер счетчика

	private static Area area; //текущий город 
	private static House house; //текущий дом (распределяемый, начисляемый)
	private static Serv serv; //текущая услуга (распределяемая, начисляемая)

	private static Serv servMet; //услуга, содержащая счетчик
	private static Serv servOdn; //услуга, содержащая счетчик ОДН
	private static int calcTp; //тип обработки расчёта
	// конструктор
	public Calc() {
	}
	
	/**
	 * настроить объект для расчета 
	 */
	public void setUp() {
		//HARDCODE!! TODO!
		Calendar calendar = new GregorianCalendar(2015, Calendar.OCTOBER, 15);
		setGenDt(calendar.getTime());
		// 1 день месяца
		calendar.set(Calendar.DATE, 1); 
		setCurDt1(calendar.getTime());
		// последний день месяца
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH)); 
		setCurDt2(calendar.getTime());
		
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

	public static House getHouse() {
		return house;
	}

	public static void setHouse(House house) {
		Calc.house = house;
	}

	public static Serv getServ() {
		return serv;
	}

	public static void setServ(Serv serv) {
		Calc.serv = serv;
		//задать услугу, содержащую счетчик
		setServMet(getServMng().getMetServ(serv));
		//задать услугу, содержащую счетчик ОДН
		
	}

	public static Serv getServMet() {
		return servMet;
	}

	public static void setServMet(Serv servMet) {
		Calc.servMet = servMet;
	}

	public static int getCalcTp() {
		return calcTp;
	}

	public static void setCalcTp(int calcTp) {
		Calc.calcTp = calcTp;
	}

	public static Serv getServOdn() {
		return servOdn;
	}

	public static void setServOdn(Serv servOdn) {
		Calc.servOdn = servOdn;
	}

	public static MeterLogMng getMetLogMng() {
		return metLogMng;
	}

	public static void setMetLogMng(MeterLogMng metLogMng) {
		Calc.metLogMng = metLogMng;
	}

	public static Date getCurDt1() {
		return curDt1;
	}

	public static void setCurDt1(Date curDt1) {
		Calc.curDt1 = curDt1;
	}

	public static Date getCurDt2() {
		return curDt2;
	}

	public static void setCurDt2(Date curDt2) {
		Calc.curDt2 = curDt2;
	}

	public static Area getArea() {
		return area;
	}

	public static void setArea(Area area) {
		Calc.area = area;
	}
	
}
