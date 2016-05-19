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
public class Calc {
	static private Date genDt; // рассчитываемая дата
	// даты текущего периода
	static private Date curDt1;
	static private Date curDt2;
	
	@Autowired
	private HouseMng houseMng; //менеджер дома
	@Autowired
	private ServMng servMng; //менеджер услуги
	@Autowired
	private MeterLogMng metLogMng; //менеджер счетчика

	private Area area; //текущий город 
	private House house; //текущий дом (распределяемый, начисляемый)
	private Serv serv; //текущая услуга (распределяемая, начисляемая)

	private Serv servMet; //услуга, содержащая счетчик
	private Serv servOdn; //услуга, содержащая счетчик ОДН
	private int calcTp; //тип обработки расчёта
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
		//задать услугу, содержащую счетчик
		setServMet(getServMng().getMetServ(serv));
		//задать услугу, содержащую счетчик ОДН
		
	}

	public Serv getServMet() {
		return servMet;
	}

	public void setServMet(Serv servMet) {
		this.servMet = servMet;
	}

	public int getCalcTp() {
		return calcTp;
	}

	public void setCalcTp(int calcTp) {
		this.calcTp = calcTp;
	}

	public Serv getServOdn() {
		return servOdn;
	}

	public void setServOdn(Serv servOdn) {
		this.servOdn = servOdn;
	}

	public MeterLogMng getMetLogMng() {
		return metLogMng;
	}

	public void setMetLogMng(MeterLogMng metLogMng) {
		this.metLogMng = metLogMng;
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
	
}
