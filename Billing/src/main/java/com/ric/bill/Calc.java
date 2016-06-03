package com.ric.bill;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ric.bill.mm.HouseMng;
import com.ric.bill.mm.KartMng;
import com.ric.bill.mm.LstMng;
import com.ric.bill.mm.MeterLogMng;
import com.ric.bill.mm.ServMng;
import com.ric.bill.mm.impl.HouseMngImpl;
import com.ric.bill.mm.impl.MeterLogMngImpl;
import com.ric.bill.mm.impl.ServMngImpl;
import com.ric.bill.model.ar.Area;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.bs.Serv;

/**
 * Хранилище всех необходимых параметров для расчета
 * @author lev
 *
 */
@Service
public final class Calc {
	private static Date genDt; //рассчитываемая дата
	//даты текущего периода
	private static Date curDt1;
	private static Date curDt2;
	//наиболее ранняя и поздние даты в биллинге, константы
	private final static Date firstDt=new GregorianCalendar(1940, Calendar.JANUARY, 01).getTime();
	private final static Date lastDt=new GregorianCalendar(2940, Calendar.JANUARY, 01).getTime();
	//кол-во дней в периоде
	private double cntCurDays;  
	//доля одного дня в периоде
	private static double partDays;

	private Calendar calendar;

	//Здесь привязывать ТОЛЬКО интерфейсы, как best practice!
	@Autowired
	private HouseMng houseMng; //менеджер дома
	@Autowired
	private KartMng kartMng; //менеджер лицевого счета
	@Autowired
	private ServMng servMng; //менеджер услуги
	@Autowired
	private MeterLogMng metLogMng; //менеджер счетчика
	@Autowired
	private LstMng lstMng; //менеджер списков

	private Area area; //текущий город 
	private House house; //текущий дом (распределяемый, начисляемый)
	//private Kart kart; //текущий лиц.счет (распределяемый, начисляемый) - пока не нужен
	private Serv serv; //текущая услуга (распределяемая, начисляемая)

	private int calcTp; //тип обработки расчёта
	
	//конструктор
	public Calc() {
	}
	
	/**
	 * настроить объект для расчета 
	 */
	public void setUp() {
		//HARDCODE!! TODO!
		calendar = new GregorianCalendar(2015, Calendar.OCTOBER, 15);
		setGenDt(calendar.getTime());
		//1 день месяца
		calendar.set(Calendar.DATE, 1); 
		setCurDt1(calendar.getTime());
		//последний день месяца
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH)); 
		setCurDt2(calendar.getTime());
		//кол-во дней в месяце
		setCntCurDays(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		//доля одного дня в периоде
		setPartDays(1/getCntCurDays());
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

	public void setHouseMng(HouseMngImpl houseMng) {
		this.houseMng = houseMng;
	}

	public ServMng getServMng() {
		return servMng;
	}

	public void setServMng(ServMngImpl servMng) {
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

	public int getCalcTp() {
		return calcTp;
	}

	public void setCalcTp(int calcTp) {
		this.calcTp = calcTp;
	}

	public MeterLogMng getMetLogMng() {
		return metLogMng;
	}

	public void setMetLogMng(MeterLogMngImpl metLogMng) {
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

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public double getCntCurDays() {
		return cntCurDays;
	}

	public void setCntCurDays(double cntCurDays) {
		this.cntCurDays = cntCurDays;
	}

	public static Date getFirstDt() {
		return firstDt;
	}

	public static Date getLastDt() {
		return lastDt;
	}

	public KartMng getKartMng() {
		return kartMng;
	}

	public void setKartMng(KartMng kartMng) {
		this.kartMng = kartMng;
	}

	public double getPartDays() {
		return partDays;
	}

	public void setPartDays(double partDays) {
		Calc.partDays = partDays;
	}

	public LstMng getLstMng() {
		return lstMng;
	}

	public void setLstMng(LstMng lstMng) {
		this.lstMng = lstMng;
	}
}
