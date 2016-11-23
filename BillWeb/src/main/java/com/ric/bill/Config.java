package com.ric.bill;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ric.bill.excp.EmptyStorable;
import com.ric.bill.mm.ObjMng;
import com.ric.bill.mm.ParMng;
import com.ric.bill.model.bs.Obj;

/**
 * Конфигуратор приложения
 * @author lev
 *
 */
@Service
public class Config {

	
	@Autowired
	private ParMng parMng;
	@Autowired
	private ObjMng objMng;

	private Calendar calendar;
	//доля одного дня в периоде
	double partDays;
	//кол-во дней в периоде
	double cntCurDays;
	//период для партицирования
	String period;
	static Date lastDt;//=new GregorianCalendar(2940, Calendar.JANUARY, 01).getTime();
	//наиболее ранняя и поздние даты в биллинге, константы
	static Date firstDt;//=new GregorianCalendar(1940, Calendar.JANUARY, 01).getTime();
	//даты текущего периода
	Date curDt2;
	Date curDt1;

	//конструктор
	public Config() {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+7"));
		
		calendar = new GregorianCalendar(1940, Calendar.JANUARY, 1);
		calendar.clear(Calendar.ZONE_OFFSET);
		firstDt = calendar.getTime();
		calendar = new GregorianCalendar(2940, Calendar.JANUARY, 1);
		calendar.clear(Calendar.ZONE_OFFSET);
		lastDt = calendar.getTime();
		
	}
	
	@PostConstruct
	private void setUp()  {
	}

	public void load() throws EmptyStorable {
		
		System.out.println("CONFIG:load");
		//Объект приложения, получить даты текущего периода
		Obj obj = objMng.getByCD("Модуль начисления");
		
		calendar = new GregorianCalendar();
		//calendar = new GregorianCalendar(2015, Calendar.OCTOBER, 15);
		calendar.clear(Calendar.ZONE_OFFSET);
		
		obj.getDw().size();
		
		calendar.setTime(parMng.getDate(obj, "Начало расчетного периода"));
		setCurDt1(calendar.getTime());
		//последний день месяца
		//calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		//calendar.set(Calendar.DATE, 2);
		calendar.setTime(parMng.getDate(obj, "Конец расчетного периода"));
		setCurDt2(calendar.getTime());
		
		//задать период для партицирования
		String yy = String.valueOf(calendar.get(Calendar.YEAR));
		String mm = String.valueOf(calendar.get(Calendar.MONTH)+1);
		mm = "0"+mm;
		mm = mm.substring(mm.length()-2, mm.length());
		setPeriod(yy+mm);
		//кол-во дней в месяце
		setCntCurDays(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		//доля одного дня в периоде
		setPartDays(1/getCntCurDays());
	}
	
	public void setCurDt2(Date curDt2) {
		this.curDt2 = curDt2;
	}

	public Date getCurDt2() {
		return curDt2;
	}

	public void setCurDt1(Date curDt1) {
		this.curDt1 = curDt1;
	}

	public Date getCurDt1() {
		return curDt1;
	}
	
	public double getCntCurDays() {
		return this.cntCurDays;
	}

	public void setCntCurDays(double cntCurDays) {
		this.cntCurDays = cntCurDays;
	}

	public static Date getLastDt() {
		return lastDt;
	}

	public static Date getFirstDt() {
		return firstDt;
	}


	public void setPartDays(double partDays) {
		this.partDays = partDays;
	}

	public double getPartDays() {
		return this.partDays;
	}

	
	public void setPeriod(String period) {
		this.period = period;
	}

	public String getPeriod() {
		return period;
	}

	
	
}
