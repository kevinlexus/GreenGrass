package com.ric.bill;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.UUID;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import com.ric.bill.mm.ParMng;

/**
 * Утилиты
 * @author lev
 *
 */
@Slf4j
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

	/**
	 * Вернуть объект Calendar по заданной дате 
	 * @param date
	 * @return
	 */
	public static Calendar getCalendar(Date date) {
	    Calendar cal = Calendar.getInstance(Locale.US);
	    cal.setTime(date);
	    return cal;
	}	
	
	//вернуть случайный UUID
	public static UUID getRndUuid() {
		return UUID.randomUUID();
	}
	
	/**
	 * Вернуть дату в XML типе
	 * @param dt
	 * @return
	 * @throws DatatypeConfigurationException
	 */
	public static XMLGregorianCalendar getXMLDate(Date dt) throws DatatypeConfigurationException {
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(dt);
		XMLGregorianCalendar xmlDt = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		return xmlDt;
	}
	
	/**
	 * Вернуть хост из строки URL
	 * @param urlStr - URL
	 * @return хост-адрес
	 * @throws UnknownHostException
	 * @throws MalformedURLException
	 */
	public static String getHostFromUrl(String urlStr) throws UnknownHostException, MalformedURLException {
		
		InetAddress address = InetAddress.getByName(new URL(urlStr).getHost());
		
		return address.getHostAddress();
	}
	
	/**
	 * Вернуть путь из строки URL
	 * @param urlStr - URL
	 * @return хост-адрес
	 * @throws UnknownHostException
	 * @throws MalformedURLException
	 */
	public static String getPathFromUrl(String urlStr) throws UnknownHostException, MalformedURLException {
		
		return new URL(urlStr).getPath();
	}
	
	/**
	 * Вернуть последнюю дату месяца 
	 * @param dt
	 * @return
	 */
	public static Date getLastDate(Date dt) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dt);
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
		return calendar.getTime();
	}

	/**
	 * Вернуть первую дату месяца 
	 * @param dt
	 * @return
	 */
	public static Date getFirstDate(Date dt) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dt);
		calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE));
		return calendar.getTime();
	}

	
	/**
	 * Вернуть дату по формату
	 * @param dt
	 * @return
	 */
	public static Date getDateFromStr(String dt) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		Date date = null;
        try {
            date = formatter.parse(dt);

        } catch (ParseException e) {
            e.printStackTrace();
        }
		return date;
	}

	/**
	 * Конвертировать XMLGregorianCalendar в Date
	 * @param cal
	 * @return
	 */
	public static Date getDateFromXmlGregCal(XMLGregorianCalendar cal) {
		if (cal != null) { 
			return cal.toGregorianCalendar().getTime();
		} else {
			return null;
		}
	}
	
	/**
	 * Получить % одного дня для заданного периода
	 * @return - % дня
	 */
	public static double getPartDays(Date dt1, Date dt2) {
		Calendar cal1 = new GregorianCalendar();
		Calendar cal2 = new GregorianCalendar();
		cal1.setTime(dt1);
		cal2.setTime(dt2);
		return 1 / (double)daysBetween(cal1.getTime(),cal2.getTime());
	}
	
	/**
	 * Вернуть кол-во дней между двумя датами
	 * @param dt1 - нач.дата
	 * @param dt2 - кон.дата
	 * @return - кол-во дней
	 */
	public static int daysBetween(Date dt1, Date dt2){
       return (int)( (dt2.getTime() - dt1.getTime()) / (1000 * 60 * 60 * 24)+1);
	}
	
	/**
	 * Конвертировать дату в ГГГГММ
	 * @param dt - дата вх.
	 * @return
	 */
	public static String getPeriodByDate(Date dt) {
		Calendar calendar = new GregorianCalendar();
		calendar.clear(Calendar.ZONE_OFFSET);
		calendar.setTime(dt);
		String yy = String.valueOf(calendar.get(Calendar.YEAR));
		String mm = String.valueOf(calendar.get(Calendar.MONTH)+1);
		mm = "0"+mm;
		mm = mm.substring(mm.length()-2, mm.length());
		return yy+mm;
	}

	/**
	 * Конвертировать период ГГГГММ в дату
	 * @param period
	 * @return
	 */
	public static Date getDateByPeriod(String period) {
		String str = "01"+"."+period.substring(4, 6)+"."+period.substring(0, 4);
		return getDateFromStr(str);
	}
	
	/**
	 * Получить кол-во дней в месяце по дате
	 * @param dt - дата вх.
	 * @return
	 */
	public static double getCntDaysByDate(Date dt) {
		Calendar calendar = new GregorianCalendar();
		calendar.clear(Calendar.ZONE_OFFSET);
		calendar.setTime(dt);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * Получить в виде ГГГГММ месяц + - N мес.
	 * @param period
	 */
	public static String addMonth(String period, int n) {
		Date dt = getDateByPeriod(period);
		Calendar calendar = new GregorianCalendar();
		calendar.clear(Calendar.ZONE_OFFSET);
		calendar.setTime(dt);
		calendar.add(Calendar.MONTH, n);
		return getPeriodByDate(calendar.getTime());
	}
}

