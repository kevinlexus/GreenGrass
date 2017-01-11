package com.ric.bill;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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
@Slf4j
public class Config {

	@Autowired
	private ParMng parMng;
	@Autowired
	private ObjMng objMng;

	private Calendar calendar;
	static Date lastDt;//=new GregorianCalendar(2940, Calendar.JANUARY, 01).getTime();
	// наиболее ранняя и поздние даты в биллинге, константы
	static Date firstDt;//=new GregorianCalendar(1940, Calendar.JANUARY, 01).getTime();

	// даты текущего периода (не зависимо от перерасчета)
	Date curDt1;
	Date curDt2;

	// конструктор
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
	private void setUp() throws EmptyStorable {
		//Объект приложения, получить даты текущего периода
		Obj obj = objMng.getByCD("Модуль начисления");
		
		calendar = new GregorianCalendar();
		//calendar = new GregorianCalendar(2015, Calendar.OCTOBER, 15);
		calendar.clear(Calendar.ZONE_OFFSET);
		
		obj.getDw().size();
		
		calendar.setTime(parMng.getDate(obj, "Начало расчетного периода"));
		setCurDt1(calendar.getTime());
		calendar.setTime(parMng.getDate(obj, "Конец расчетного периода"));
		setCurDt2(calendar.getTime());
		log.info("Начало расчетного периода = {}", getCurDt1());
		log.info("Конец расчетного периода = {}", getCurDt2());
	}


	public void setCurDt1(Date curDt1) {
		this.curDt1 = curDt1;
	}

	public Date getCurDt1() {
		return curDt1;
	}
	
	public void setCurDt2(Date curDt2) {
		this.curDt2 = curDt2;
	}

	public Date getCurDt2() {
		return curDt2;
	}

	public static Date getLastDt() {
		return lastDt;
	}

	public static Date getFirstDt() {
		return firstDt;
	}



}
