package com.ric.bill;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ric.bill.mm.HouseMng;
import com.ric.bill.mm.KartMng;
import com.ric.bill.mm.LstMng;
import com.ric.bill.mm.MeterLogMng;
import com.ric.bill.mm.ParMng;
import com.ric.bill.mm.ServMng;
import com.ric.bill.mm.TarifMng;
import com.ric.bill.mm.impl.HouseMngImpl;
import com.ric.bill.mm.impl.MeterLogMngImpl;
import com.ric.bill.mm.impl.ServMngImpl;
import com.ric.bill.model.ar.Area;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.ar.Kart;
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

	private Area area; //текущий город 
	private House house; //текущий дом (распределяемый, начисляемый)
	private static Kart kart; //текущий лиц.счет (распределяемый, начисляемый)
	private Serv serv; //текущая услуга (распределяемая, начисляемая)

	//установлены ли параметры расчета дома, даты фильтра и т.п.
	private static boolean init = false;
	
	private int calcTp; //тип обработки расчёта
	//уровень отладки
	private static int dbgLvl;
	
	private HashSet<Check> lstCheck;
	
	/**
	 * внутренний класс, для проверок расчета узлов
	 * @author lev
	 *
	 */
	private class Check {
		private int id; //ID объекта
		private int tp; //тип расчета
		private Date genDt; //дата расчета
		private NodeVol nodeVol;//рассчитанные объемы
		
		public Check(int id, int tp, Date genDt, NodeVol nodeVol) {
			setId(id);
			setTp(tp);
			setGenDt(genDt);
			setNodeVol(nodeVol);
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getTp() {
			return tp;
		}
		public void setTp(int tp) {
			this.tp = tp;
		}
		public Date getGenDt() {
			return genDt;
		}
		public void setGenDt(Date genDt) {
			this.genDt = genDt;
		}

		public NodeVol getNodeVol() {
			return nodeVol;
		}

		public void setNodeVol(NodeVol nodeVol) {
			this.nodeVol = nodeVol;
		}
		
	}
	
	//конструктор
	public Calc() {
		lstCheck = new HashSet<Check>();
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
	public void setUp() {
		//HARDCODE!! TODO!
		calendar = new GregorianCalendar(2015, Calendar.OCTOBER, 15);
		calendar.clear(Calendar.ZONE_OFFSET);
		
		setGenDt(calendar.getTime());
		//1 день месяца
		calendar.set(Calendar.DATE, 1); 
		setCurDt1(calendar.getTime());
		//последний день месяца
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		//calendar.set(Calendar.DATE, 2); 
		
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

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public static double getCntCurDays() {
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

	public static Kart getKart() {
		return kart;
	}

	public void setKart(Kart kart) {
		Calc.kart = kart;
	}

	//Отправить в консоль сообщение
	public static void mess(String txt) {
			DateTimeFormatter frmt = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
			ZonedDateTime dt = ZonedDateTime.now();
			if (getDbgLvl() > 0 ) {
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

	/**
	 * Поиск расчитанного объема заданного по ID объекта
	 * @param id - ID
	 * @param tp - тип расчета
	 * @param genDt - дата расчета
	 * @return - найденный объем
	 */
	public NodeVol findLstCheck(int id, int tp, Date genDt) {
		for (Check c : lstCheck) {
			if (c.getId()==id && c.getTp()==tp && c.getGenDt().equals(genDt)) {
				if (id==3670885) {
				  Calc.mess("НАЙДЕНО ВХОЖДЕНИЕ id="+id+" tp="+tp+" genDt="+genDt.toLocaleString(), 2);
				}
				return c.getNodeVol();
			}
		}
		return null;
	}
	
	/**
	 * Добавление расчитанного объекта
	 * @param id - ID
	 * @param tp - тип расчета
	 * @param genDt - дата расчета
	 */
	public void addLstCheck(int id, int tp, Date genDt, NodeVol nodeVol) {
		  lstCheck.add(new Check(id, tp, genDt, nodeVol));
/*		  if (id==3670885) {
			  Calc.mess("Записано id="+id+" tp="+tp+" genDt="+genDt.toLocaleString(), 2);
		  }*/
	}

	/**
	 * Почистить коллекцию, содержащую расчитанные объемы
	 */
	public void clearLstChecks() {
		lstCheck.clear();
	}
	
	
}
