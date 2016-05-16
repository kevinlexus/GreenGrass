package com.ric.bill;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Хранилище всех необходимых параметров для расчета
 * @author lev
 *
 */
public class Calc {

	static private Date genDt; // рассчитываемая дата
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

	
}
