package com.ric.bill;

import java.util.Date;

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
		if ((checkDt.after(dt1) || checkDt.equals(dt1))
			&&
			(checkDt.before(dt2) || checkDt.equals(dt2))) {
			return true;
		} else {
			return false;
		}
	}
	
}
