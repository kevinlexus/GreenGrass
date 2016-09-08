package com.ric.bill;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.excp.EmptyServ;
import com.ric.bill.excp.ErrorWhileChrg;
import com.ric.bill.excp.ErrorWhileDist;
import com.ric.bill.excp.NotFoundNode;
import com.ric.bill.excp.NotFoundODNLimit;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.mm.HouseMng;
import com.ric.bill.mm.KartMng;
import com.ric.bill.mm.LstMng;
import com.ric.bill.mm.MeterLogMng;
import com.ric.bill.mm.ParMng;
import com.ric.bill.mm.ServMng;
import com.ric.bill.mm.VolMng;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.mt.MLogs;

/**
 * Сервис распределения объемов
 * @author lev
 *
 */
@Service
@Scope("prototype")
public class DistServ {

	@Autowired
	private Calc calc;
	@Autowired
	private MeterLogMng metMng;
	@Autowired
	private KartMng kartMng;
	@Autowired
	private ParMng parMng;
	@Autowired
	private LstMng lstMng;
	@Autowired
	private ServMng servMng;
	@Autowired
	private HouseMng houseMng;
	@Autowired
	private VolMng volMng;
	@Autowired
	private DistGen distGen;
	@Autowired
    private ChrgServ chrg;

	//EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;

    /**
	 * Установить фильтры для сессии -убрал пока
	 * 
	 */
/*	private void setFilters() {
		Session session = em.unwrap(Session.class);
		Calc.mess("Установлен фильтр: c:"+Calc.getCurDt1()+" по:"+Calc.getCurDt2());
		session.enableFilter("FILTER_GEN_DT_OUTER").setParameter("DT1", Calc.getCurDt1())
		   .setParameter("DT2", Calc.getCurDt2());
		//отдельно установить фильтр существования счетчиков
	}*/

	/**
	 * Удалить объем по вводам дома
	 * 
	 * @param serv - заданная услуга
	 */
    private void delHouseVolServ(Serv serv) {
		delHouseServVolTp(serv.getServMet(), 1);
		delHouseServVolTp(serv.getServMet(), 0);
		delHouseServVolTp(serv.getServMet(), 2);
		delHouseServVolTp(serv.getServMet(), 3);
		if (serv.getServOdn() != null){
			delHouseServVolTp(serv.getServOdn(), 0);//счетчики ОДН
		} 
	}

	
	/**
	 * Удалить объем по дому, определённой услуге
	 * @param tp - тип расчета
	 * @param serv - услуга
	 */
	private void delHouseServVolTp(Serv serv, int tp) {
		//перебрать все необходимые даты, за период
		Calendar c = Calendar.getInstance();
		//необходимый для формирования диапазон дат
		Date dt1, dt2;
		if (calc.getCalcTp()==2) {
			//формирование по ОДН - задать последнюю дату
			dt1 = Calc.getCurDt2();
			dt2 = Calc.getCurDt2();
		} else {
			//прочее формирование
			dt1 = Calc.getCurDt1();
			dt2 = Calc.getCurDt2();
		}

		//найти все вводы по дому и по услуге
		for (c.setTime(dt1); !c.getTime().after(dt2); c.add(Calendar.DATE, 1)) {
			Calc.setGenDt(c.getTime());
			for (MLogs ml : metMng.getAllMetLogByServTp(calc.getHouse(), serv, "Ввод")) {
				metMng.delNodeVol(ml, tp, Calc.getGenDt());
			}
		}
		
		
	}
	
	
	/**
	 * Удалить объем по Лиц.счету, определённой услуге
	 * @param Kart - лиц.счет
	 * @param serv - услуга
	 * @param tp - тип расчета
	 */
	private void delKartServVolTp(Kart kart, Serv serv, int tp) {
		//перебрать все необходимые даты, за период
		Calendar c = Calendar.getInstance();
		//необходимый для формирования диапазон дат
		Date dt1, dt2;
		if (calc.getCalcTp()==2) {
			//формирование по ОДН - задать последнюю дату
			dt1 = Calc.getCurDt2();
			dt2 = Calc.getCurDt2();
		} else {
			//прочее формирование
			dt1 = Calc.getCurDt1();
			dt2 = Calc.getCurDt2();
		}

		//найти все счетчики по Лиц.счету, по услуге
		for (c.setTime(dt1); !c.getTime().after(dt2); c.add(Calendar.DATE, 1)) {
			Calc.setGenDt(c.getTime());
			
			for (MLogs ml : metMng.getAllMetLogByServTp(kart, serv, "Ввод")) {
				metMng.delNodeVol(ml, tp, Calc.getGenDt());
			}
			
		}
	}
	
	/**
	 * Очистить кэш
	 */
	/*@Caching(evict = {
			@CacheEvict(cacheNames="readWriteCache", allEntries=true),
			@CacheEvict(cacheNames="readOnlyCache", allEntries=true)
	})
	public void clearCache(){
		
	}*/

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void distAll() {
		long startTime;
		long endTime;
		long totalTime;
		try {
			for (House o: houseMng.findAll2()) {
				System.out.println("ДОМ:"+o.getId());
				//распределить объемы
				startTime = System.currentTimeMillis();
				Calc.setInit(false);
				
				distHouseVol(o.getId());
				//передать по ID иначе кэшируется
				endTime   = System.currentTimeMillis();
				totalTime = endTime - startTime;
				System.out.println("Время исполнения-1:"+totalTime);
				
				//Logger.getLogger("org.hibernate.SQL").setLevel(Level.DEBUG);
				//Logger.getLogger("org.hibernate.type").setLevel(Level.TRACE);
				
				startTime = System.currentTimeMillis();
				endTime   = System.currentTimeMillis();
				totalTime = endTime - startTime;
				System.out.println("Время исполнения-3:"+totalTime);
				
			}
		} catch (ErrorWhileDist e) {
			e.printStackTrace();
		}
		
    }
	
	/**
	 * распределить объем по дому
	 * @param houseId - Id дома, иначе кэшируется, если передавать объект дома
	 * @throws ErrorWhileDist 
	 */
	//@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    //@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void distHouseVol(int houseId) throws ErrorWhileDist {
		
		calc.setUp(); //настроить даты и т.п.
		//calc.clearLstChecks();//почистить рассчитанные объемы

		House h = em.find(House.class, houseId);
		if (!Calc.isInit()) {
			calc.setHouse(h);
			calc.setArea(calc.getHouse().getStreet().getArea());
			Calc.setInit(true);
		}
		Calc.mess("Дом: id="+calc.getHouse().getId(), 2);
		Calc.mess("Дом: klsk="+calc.getHouse().getKlsk(), 2);

		
		//Calc.mess("Парам="+parMng.getDbl(h, "RRR-CHECK", Calc.getCurDt1()));
		/*Serv serv = servMng.getByCD("Холодная вода (объем)");	
		Calc.mess("услуга 1:"+serv.getName(), 2);
		serv = servMng.getByCD("Отопление ОДН");	
		Calc.mess("услуга 2:"+serv.getName(), 2);
		serv = servMng.getByCD("Холодная вода (объем)");	
		Calc.mess("услуга 3:"+serv.getName(), 2);*/
		
		/*Calc.mess("Дом: 1============================================================",2);
		h = em.find(House.class, 1737);
		//System.out.println("Парам="+parMng.getDbl(h, "Площадь.Жилая", Calc.getCurDt1()));
		Calc.mess("Парам="+parMng.getDbl(h, "RRR-CHECK", Calc.getCurDt1()));

		Calc.mess("Дом: 2============================================================",2);
		h = em.find(House.class, 1744);
		//System.out.println("Парам="+parMng.getDbl(h, "Площадь.Жилая", Calc.getCurDt1()));
		Calc.mess("Парам="+parMng.getDbl(h, "RRR-CHECK", Calc.getCurDt1()));*/
		
		Calc.mess("Очистка объемов");
		//найти все необходимые услуги для удаления объемов
		for (Serv serv : servMng.findForDistVol()) {
				//calc.setServ(s);
				delHouseVolServ(serv);
		}

		Calc.mess("Распределение объемов");
		//найти все необходимые услуги для распределения
		try {
			for (Serv serv : servMng.findForDistVol()) {
				//calc.setServ(s);
				Calc.mess("Распределение услуги: "+serv.getCd());
				  distHouseServ(serv);
			}
		} catch (ErrorWhileDist e) {
			e.printStackTrace();
			throw new ErrorWhileDist("Dist.distHouseVol: ");
		}

		//calc.showAllChecks();
		
	}
	
	
	/**
	 * распределить объем по услуге данного дома
	 * @throws ErrorWhileDist 
	 */
	private void distHouseServ(Serv serv) throws ErrorWhileDist {
		Calc.mess("******************Услуга*************="+serv.getCd());
		calc.setCalcTp(1);
		distHouseServTp(serv.getServMet());//Расчет площади, кол-во прожив
		calc.setCalcTp(0);
		distHouseServTp(serv.getServMet());//Распределение объема
		calc.setCalcTp(2);
		distHouseServTp(serv.getServMet());//Расчет ОДН
		calc.setCalcTp(3);
		distHouseServTp(serv.getServMet());//Расчет пропорц.площади
		if (serv.getServOdn() != null){
			calc.setCalcTp(0);
			distHouseServTp(serv.getServOdn());//Суммировать счетчики ОДН
		}
	}
	
	/**
	 * Распределить объем по вводам дома
	 * @param calcTp - тип обработки
	 * @throws ErrorWhileDist 
	 */
	private void distHouseServTp(Serv serv) throws ErrorWhileDist {
		Calc.mess("Распределение по типу:"+calc.getCalcTp());
		//найти все вводы по дому и по услуге
		for (MLogs ml : metMng.getAllMetLogByServTp(calc.getHouse(), serv, "Ввод")) {
				Calc.mess("Вызов distGraph c id="+ml.getId());
				distGraph(ml);
		}
	}
	
	/**
	 * Распределить граф начиная с mLog
	 * @param ml - начальный узел распределения
	 * @throws ErrorWhileDist 
	 */
	private void distGraph (MLogs ml) throws ErrorWhileDist {
		Calc.mess("Распределение ввода:"+ml.getId());
		//перебрать все необходимые даты, за период
		Calendar c = Calendar.getInstance();
		//необходимый для формирования диапазон дат
		Date dt1, dt2;
		if (calc.getCalcTp()==2) {
			//формирование по ОДН - задать последнюю дату
			dt1 = Calc.getCurDt2();
			dt2 = Calc.getCurDt2();
		} else {
			//прочее формирование
			dt1 = Calc.getCurDt1();
			dt2 = Calc.getCurDt2();
		}
		
		for (c.setTime(dt1); !c.getTime().after(dt2); c.add(Calendar.DATE, 1)) {
			Calc.setGenDt(c.getTime());
			//Calc.beginTimer();
			//Calc.mess("по дате="+Calc.getGenDt(), 2);
			@SuppressWarnings("unused")
			NodeVol dummy;
			try {
				dummy=distGen.distNode(ml, calc.getCalcTp(), Calc.getGenDt());
			} catch (WrongGetMethod e) {
				e.printStackTrace();
				throw new ErrorWhileDist("Dist.distGraph: При расчете счетчика MeterLog.Id="+ml.getId()+" , обнаружен замкнутый цикл");  
			} catch (EmptyServ e) {
				e.printStackTrace();
				throw new ErrorWhileDist("Dist.distGraph: Пустая услуга при рекурсивном вызове BillServ.distNode()");
			} catch (NotFoundODNLimit e) {
				e.printStackTrace();
				throw new ErrorWhileDist("Dist.distGraph: Не найден лимит ОДН в счетчике ОДН, при вызове BillServ.distNode()");
			} catch (NotFoundNode e) {
				e.printStackTrace();
				throw new ErrorWhileDist("Dist.distGraph: Не найден нужный счетчик, при вызове BillServ.distNode(): ");
			}
			//Calc.showTimer(calc.getCalcTp()+" тип");
			
			//break;
		}

		
	}
	
}
