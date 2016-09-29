package com.ric.bill;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;

import com.ric.bill.mm.ParMng;

/**
 * Утилиты
 * @author lev
 *
 */
public class Utl {

	/**
	 * вернуть второе значение, если первое пусто (аналог oracle NVL)
	 * @param a - 1 значение
	 * @param b - 2 значение
	 * @return
	 */
	public static <T> T nvl(T a, T b) {
		return (a == null) ? b : a;
	}

	/**
	 * вернуть, если дата находится в диапазоне периода
	 * @param checkDt - проверяемая дата
	 * @param dt1 - начало периода
	 * @param dt2 - окончание периода
	 * @return
	 */
	public static boolean between(Date checkDt, Date dt1, Date dt2) {
		if (dt1 == null) {
			dt1 = Config.getFirstDt();
		}
		if (dt2 == null) {
			dt2 = Config.getLastDt();
		}
		
		if (checkDt.getTime() >= dt1.getTime() &&
				checkDt.getTime() <= dt2.getTime()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * вернуть true если хотя бы одна из дат находится в двух диапазонах периода
	 * @param checkDt1 - проверяемая дата
	 * @param checkDt2 - проверяемая дата
	 * @param dt1 - начало периода
	 * @param dt2 - окончание периода
	 * @return
	 */
	public static boolean between2(Date checkDt1, Date checkDt2, Date dt1, Date dt2) {
		return between(checkDt1, dt1, dt2) || between(checkDt2, dt1, dt2);
	}
	
	//вернуть кол-во лет между датами
	public static int getDiffYears(Date first, Date last) {
	    Calendar a = getCalendar(first);
	    Calendar b = getCalendar(last);
	    int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
	    if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH) || 
	        (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a.get(Calendar.DATE) > b.get(Calendar.DATE))) {
	        diff--;
	    }
	    return diff;
	}

	//вернуть объект Calendar по заданной дате
	public static Calendar getCalendar(Date date) {
	    Calendar cal = Calendar.getInstance(Locale.US);
	    cal.setTime(date);
	    return cal;
	}	
	
}
