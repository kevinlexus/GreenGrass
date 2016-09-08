package com.ric.bill;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import com.ric.bill.mm.ObjMng;
import com.ric.bill.mm.ParMng;
import com.ric.bill.model.ar.Area;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.bs.Obj;
import com.ric.bill.model.bs.Serv;

/**
 * Хранилище всех необходимых параметров для расчета
 * @author lev
 *
 */
@ContextConfiguration(locations = { "classpath:spring.xml" })
@Service
public final class Calc {
	private static Date genDt; //рассчитываемая дата
	//даты текущего периода
	private static Date curDt1;
	private static Date curDt2;
	//период для партицирования
	private static String period;
	//наиболее ранняя и поздние даты в биллинге, константы
	private static Date firstDt;//=new GregorianCalendar(1940, Calendar.JANUARY, 01).getTime();
	private static Date lastDt;//=new GregorianCalendar(2940, Calendar.JANUARY, 01).getTime();
	//кол-во дней в периоде
	private static double cntCurDays;  
	//доля одного дня в периоде
	private static double partDays;

	private Calendar calendar;
	
	//для отладки
	public static long startTime;
	public static long endTime;

//	private static Area area; //текущий город 
//	private static House house; //текущий дом (распределяемый, начисляемый)
//	private static Kart kart; //текущий лиц.счет (распределяемый, начисляемый)
	//private static Serv serv; //текущая услуга (распределяемая, начисляемая)

	//установлены ли параметры расчета дома, даты фильтра и т.п.
	private static boolean init = false;
	
	private int calcTp; //тип обработки расчёта
	//уровень отладки
	private static int dbgLvl;
	
	//EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;
    
	@Autowired
	private ObjMng objMng;
	
	@Autowired
	private ParMng parMng;
	
	
	//конструктор
	public Calc() {
		System.out.println("CHECK!===================================1");
		calendar = new GregorianCalendar(1940, Calendar.JANUARY, 1);
		calendar.clear(Calendar.ZONE_OFFSET);
		firstDt = calendar.getTime();
		calendar = new GregorianCalendar(2940, Calendar.JANUARY, 1);
		calendar.clear(Calendar.ZONE_OFFSET);
		lastDt = calendar.getTime();
	}
	
	/**
	 * настроить объект для расчета 
	 */
	@PostConstruct
	private void setUp() {
		//Объект приложения, получить даты текущего периода
		
		Obj obj = objMng.getByCD("Модуль начисления"); 
		
		//MileageFeeCalculator calc = ApplicationContextHolder.getContext().getBean(MileageFeeCalculator.class);
        
		calendar = new GregorianCalendar();
		//calendar = new GregorianCalendar(2015, Calendar.OCTOBER, 15);
		calendar.clear(Calendar.ZONE_OFFSET);
		
		setGenDt(calendar.getTime());
		//1 день месяца
		//calendar.set(Calendar.DATE, 1); 
		//Calc.mess("OBJ=="+obj,2);
		Date ddd = parMng.getDate(obj, "Начало расчетного периода");
		//Calc.mess("ddd=="+ddd,2);
		
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
	
	public static Date getGenDt() {
		return genDt;
	}

	public static void setGenDt(Date genDt) {
		Calc.genDt = genDt;
	}

	/*public static House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		Calc.house = house;
	}*/

	/*public Serv getServ() {
		return serv;
	}

	public static void setServ(Serv serv) {
		Calc.serv = serv;
		
	}*/

	public int getCalcTp() {
		return this.calcTp;
	}

	public void setCalcTp(int calcTp) {
		this.calcTp = calcTp;
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

/*	public static Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		Calc.area = area;
	}*/

	public static double getCntCurDays() {
		return cntCurDays;
	}

	public void setCntCurDays(double cntCurDays) {
		Calc.cntCurDays = cntCurDays;
	}

	public static Date getFirstDt() {
		return firstDt;
	}

	public static Date getLastDt() {
		return lastDt;
	}

	public double getPartDays() {
		return partDays;
	}

	public void setPartDays(double partDays) {
		Calc.partDays = partDays;
	}

	public static void beginTimer() {
		Calc.startTime=System.currentTimeMillis();
	}
	
	public static void showTimer(String mess) {
		Calc.endTime=System.currentTimeMillis();
		System.out.println("************ "+mess+" затрачено="+Long.toString(Calc.endTime-Calc.startTime));
	}

	/*public static Kart getKart() {
		return kart;
	}

	public void setKart(Kart kart) {
		Calc.kart = kart;
	}*/

	//Отправить в консоль сообщение
	public static void mess(String txt) {
			DateTimeFormatter frmt = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
			ZonedDateTime dt = ZonedDateTime.now();
			if (getDbgLvl() <=1 ) {
				System.out.println(dt.format(frmt)+' '+txt);
			}
		}

	//Отправить в консоль сообщение с уровнем выше dbgLvl
	public static void mess(String txt, int dbgLvl) {
			DateTimeFormatter frmt = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
			ZonedDateTime dt = ZonedDateTime.now();
			if (dbgLvl >= getDbgLvl()) {
				System.out.println(dt.format(frmt)+' '+txt);
			}
		}

	public static int getDbgLvl() {
		return dbgLvl;
	}

	public static void setDbgLvl(int dbgLvl) {
		Calc.dbgLvl = dbgLvl;
	}

	public static boolean isInit() {
		return init;
	}

	public static void setInit(boolean init) {
		Calc.init = init;
	}
	
	public static String getPeriod() {
		return period;
	}

	public static void setPeriod(String period) {
		Calc.period = period;
	}

	/**
	 * таблица для возврата норматива потребления (в литрах) по соотв.площади на человека
	 * @param oplMan - площадь на человека
	 * @return
	 */
	public double oplLiter(Double oplMan) {
		int inVal = (int) Math.round(oplMan);
		double val=0d;
		
		switch (inVal) {
		case 1: val = 2;
		break;
		case 2: val = 2;
		break;
		case 3: val = 2;
		break;
		case 4: val = 10;
		break;
		case 5: val = 10;
		break;
		case 6: val = 10;
		break;
		case 7: val = 10;
		break;
		case 8: val = 10;
		break;
		case 9: val = 10;
		break;
		case 10: val = 9;
		break;
		case 11: val = 8.2;
		break;
		case 12: val = 7.5;
		break;
		case 13: val = 6.9;
		break;
		case 14: val = 6.4;
		break;
		case 15: val = 6.0;
		break;
		case 16: val = 5.6;
		break;
		case 17: val = 5.3;
		break;
		case 18: val = 5.0;
		break;
		case 19: val = 4.7;
		break;
		case 20: val = 4.5;
		break;
		case 21: val = 4.3;
		break;
		case 22: val = 4.1;
		break;
		case 23: val = 3.9;
		break;
		case 24: val = 3.8;
		break;
		case 25: val = 3.6;
		break;
		case 26: val = 3.5;
		break;
		case 27: val = 3.3;
		break;
		case 28: val = 3.2;
		break;
		case 29: val = 3.1;
		break;
		case 30: val = 3.0;
		break;
		case 31: val = 2.9;
		break;
		case 32: val = 2.8;
		break;
		case 33: val = 2.7;
		break;
		case 34: val = 2.6;
		break;
		case 35: val = 2.6;
		break;
		case 36: val = 2.5;
		break;
		case 37: val = 2.4;
		break;
		case 38: val = 2.4;
		break;
		case 39: val = 2.3;
		break;
		case 40: val = 2.3;
		break;
		case 41: val = 2.2;
		break;
		case 42: val = 2.1;
		break;
		case 43: val = 2.1;
		break;
		case 44: val = 2;
		break;
		case 45: val = 2;
		break;
		case 46: val = 2;
		break;
		case 47: val = 1.9;
		break;
		case 48: val = 1.9;
		break;
		case 49: val = 1.8;
		break;
		default: val = 1.8;
		
		}
		
		return val;
	}

}
