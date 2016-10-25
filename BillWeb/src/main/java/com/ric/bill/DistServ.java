package com.ric.bill;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.excp.EmptyServ;
import com.ric.bill.excp.EmptyStorable;
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
	private ApplicationContext ctx;
	@Autowired
	private Config config;
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
	
	@Autowired //-здесь не надо autowire, так как prototype
	private DistGen distGen;
	
	@Autowired
    private ChrgServ chrg;

	//EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;

    private Calc calc;
    
    
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

    
    //конструктор
    public DistServ() {
    	//расчетный объект
    	this.calc=new Calc();
    }
    
	/**
	 * Удалить объем по вводам дома
	 * 
	 * @param serv - заданная услуга
	 */
    private void delHouseVolServ() {

    	Calc.mess("Удаление объемов по Дому: id="+calc.getHouse().getId(), 2);

		delHouseServVolTp(calc.getServ().getServMet(), 1);
		delHouseServVolTp(calc.getServ().getServMet(), 0);
		delHouseServVolTp(calc.getServ().getServMet(), 2);
		delHouseServVolTp(calc.getServ().getServMet(), 3);
		if (calc.getServ().getServOdn() != null){
			delHouseServVolTp(calc.getServ().getServOdn(), 0);//счетчики ОДН
		} 
	}

	
	/**
	 * Удалить объем по вводу, определённой услуге
	 * @param serv - услуга
	 */
	private void delHouseServVolTp(Serv serv, int tp) {
		//перебрать все необходимые даты, за период
		Calendar c = Calendar.getInstance();
		//необходимый для формирования диапазон дат
		Date dt1, dt2;
		if (calc.getCalcTp()==2) {
			//формирование по ОДН - задать последнюю дату
			dt1 = config.getCurDt2();
			dt2 = config.getCurDt2();
		} else {
			//прочее формирование
			dt1 = config.getCurDt1();
			dt2 = config.getCurDt2();
		}

		//найти все вводы по дому и по услуге
		for (MLogs ml : metMng.getAllMetLogByServTp(calc.getHouse(), serv, "Ввод")) {
			//Calc.mess("ПРОВЕРКА, УБРАТЬ1! " +ml.getInside().size(),2);
			//Calc.mess("ПРОВЕРКА, УБРАТЬ2! " +ml.getOutside().size(),2);
			metMng.delNodeVol(ml, tp, config.getCurDt1(), config.getCurDt2());
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
    public void distAll(Calc calc) {
			//distGen = ctx.getBean(DistGen.class);
			this.calc=calc;
			long startTime;
			long endTime;
			long totalTime;
			for (House o: houseMng.findAll2()) {
				System.out.println("ДОМ:"+o.getId());
				//dist.clearCache();
				//распределить объемы
				startTime = System.currentTimeMillis();
				//Logger.getLogger("org.hibernate.SQL").setLevel(Level.DEBUG);
				//Logger.getLogger("org.hibernate.type").setLevel(Level.TRACE);
		    	
				try {
					distHouseVol(o.getId());
				} catch (ErrorWhileDist e) {
					e.printStackTrace();
				}
				endTime   = System.currentTimeMillis();
				totalTime = endTime - startTime;
				System.out.println("Время исполнения-1:"+totalTime);
				
				
			}
		
    }
	
	
	/**
	 * распределить объем по всем услугам, по лиц.счету
	 * @throws ErrorWhileDist 
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void distKartVol(Calc calc) throws ErrorWhileDist {
		this.calc=calc;

		calc.setCalcTp(0);

		Kart kart = em.find(Kart.class, calc.getKart().getLsk());
		//почистить коллекцию обработанных счетчиков
		distGen.clearLstChecks();

		//найти все необходимые услуги для удаления объемов, здесь только по типу 0 и только те услуги, которые надо удалить для ЛС 
		for (Serv serv : servMng.findForDistVolForKart()) {
				Calc.mess("Удаление объема по услуге"+serv.getCd());
				delKartServVolTp(kart, serv, 0);
		}
		
		Calc.mess("Распределение объемов");
		//найти все необходимые услуги для распределения
		 
		 try {
			for (Serv serv : servMng.findForDistVol()) {
				Calc.mess("Распределение услуги: "+serv.getCd());
				  distKartServTp(kart, serv);
			}
		} catch (ErrorWhileDist e) {
			e.printStackTrace();
			throw new ErrorWhileDist("Dist.distHouseVol: ");
		}

	}
	
	/**
	 * Удалить объем по Лиц.счету, определённой услуге
	 * @param Kart - лиц.счет
	 * @param serv - услуга
	 * @param tp - тип расчета
	 */
	private void delKartServVolTp(Kart kart, Serv serv, int tp) {
		Calc.mess("delKartServVolTp: kart.lsk="+kart.getLsk()+", serv.cd="+serv.getCd()+" tp="+tp);
		//перебрать все необходимые даты, за период
		Calendar c = Calendar.getInstance();
		//необходимый для формирования диапазон дат
		Date dt1, dt2;
		if (calc.getCalcTp()==2) {
			//формирование по ОДН - задать последнюю дату
			dt1 = config.getCurDt2();
			dt2 = config.getCurDt2();
		} else {
			//прочее формирование
			dt1 = config.getCurDt1();
			dt2 = config.getCurDt2();
		}

		//найти все счетчики по Лиц.счету, по услуге
		for (c.setTime(dt1); !c.getTime().after(dt2); c.add(Calendar.DATE, 1)) {
			calc.setGenDt(c.getTime());
			
			for (MLogs ml : metMng.getAllMetLogByServTp(kart, serv, null)) {
				metMng.delNodeVol(ml, tp, config.getCurDt1(), config.getCurDt2());
			}
			
		}
	}

	
	/**
	 * Распределить объем по счетчикам дома
	 * @param calcTp - тип обработки
	 * @throws ErrorWhileDist 
	 */
	private void distKartServTp(Kart kart, Serv serv) throws ErrorWhileDist {
		//найти все вводы по лиц.счету и по услуге
		for (MLogs ml : metMng.getAllMetLogByServTp(kart, serv, null)) {
				distGraph(ml);
		}
	}
	
	/**
	 * распределить объем по дому
	 * @param houseId - Id дома, иначе кэшируется, если передавать объект дома
	 * @throws ErrorWhileDist 
	 */
	//@Transactional(readOnly = false, propagation = Propagation.REQUIRED) //  ПРИМЕНЯТЬ ТОЛЬКО НА PUBLIC МЕТОДЕ!!! http://stackoverflow.com/questions/4396284/does-spring-transactional-attribute-work-on-a-private-method
	public void distHouseVol(int houseId) throws ErrorWhileDist {
		

		House h = em.find(House.class, houseId);
		//установить инициализацию дома
    	//установить дом и счет
		calc.setHouse(h);
		/*Calc.mess("Дом: 1============================================================",2);
		h = em.find(House.class, 1737);
		//System.out.println("Парам="+parMng.getDbl(h, "Площадь.Жилая", Calc.getCurDt1()));
		Calc.mess("Парам="+parMng.getDbl(h, "RRR-CHECK", Calc.getCurDt1()));

		Calc.mess("Дом: 2============================================================",2);
		h = em.find(House.class, 1744);
		//System.out.println("Парам="+parMng.getDbl(h, "Площадь.Жилая", Calc.getCurDt1()));
		Calc.mess("Парам="+parMng.getDbl(h, "RRR-CHECK", Calc.getCurDt1()));*/
		
		Calc.mess("DistServ.distHouseVol: Очистка объемов по дому id="+calc.getHouse().getId()+" klsk="+calc.getHouse().getKlsk(), 2);
		//почистить коллекцию обработанных счетчиков
		distGen.clearLstChecks();

		//найти все необходимые услуги для удаления объемов
		for (Serv s : servMng.findForDistVol()) {
				calc.setServ(s);
				delHouseVolServ();
		}

		//if (1==1) {
		//	return;
		//}
		
		Calc.mess("DistServ.distHouseVol: Распределение объемов по дому id="+calc.getHouse().getId()+" klsk="+calc.getHouse().getKlsk(), 2);
		//найти все необходимые услуги для распределения
		try {
			for (Serv s : servMng.findForDistVol()) {
				calc.setServ(s);
				Calc.mess("DistServ.distHouseVol: Распределение услуги: "+s.getCd(),2);
				  distHouseServ();
			}
		} catch (ErrorWhileDist e) {
			e.printStackTrace();
			throw new ErrorWhileDist("Dist.distHouseVol: ");
		}

		//System.gc();
		//Calc.showAllChecks();
		
	}
	
	
	/**
	 * распределить объем по услуге данного дома
	 * @throws ErrorWhileDist 
	 */
	private void distHouseServ() throws ErrorWhileDist {
		Calc.mess("******************Услуга*************="+calc.getServ().getCd());
		calc.setCalcTp(1);
		distHouseServTp(calc.getServ().getServMet());//Расчет площади, кол-во прожив
		calc.setCalcTp(0);
		distHouseServTp(calc.getServ().getServMet());//Распределение объема
		calc.setCalcTp(2);
		distHouseServTp(calc.getServ().getServMet());//Расчет ОДН
		calc.setCalcTp(3);
		distHouseServTp(calc.getServ().getServMet());//Расчет пропорц.площади
		if (calc.getServ().getServOdn() != null){
			calc.setCalcTp(0);
			distHouseServTp(calc.getServ().getServOdn());//Суммировать счетчики ОДН
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
		Calc.mess("DistServ.distGraph: Распределение счетчика:"+ml.getId());
		//перебрать все необходимые даты, за период
		Calendar c = Calendar.getInstance();
		//необходимый для формирования диапазон дат
		Date dt1, dt2;
		if (calc.getCalcTp()==2) {
			//формирование по ОДН - задать последнюю дату
			dt1 = config.getCurDt2();
			dt2 = config.getCurDt2();
		} else {
			//прочее формирование
			dt1 = config.getCurDt1();
			dt2 = config.getCurDt2();
		}
		
		for (c.setTime(dt1); !c.getTime().after(dt2); c.add(Calendar.DATE, 1)) {
			calc.setGenDt(c.getTime());
			//Calc.beginTimer();
			//Calc.mess("по дате="+Calc.getGenDt(), 2);
			@SuppressWarnings("unused")
			NodeVol dummy;
			try {
				dummy=distGen.distNode(calc, ml, calc.getCalcTp(), calc.getGenDt());
				
				
			} catch (WrongGetMethod e) {
				e.printStackTrace();
				throw new ErrorWhileDist("Dist.distGraph: При расчете счетчика MeterLog.Id="+ml.getId()+" , обнаружен замкнутый цикл");  
			} catch (EmptyServ e) {
				e.printStackTrace();
				throw new ErrorWhileDist("Dist.distGraph: Пустая услуга при рекурсивном вызове BillServ.distNode()");
			} catch (EmptyStorable e) {
				e.printStackTrace();
				throw new ErrorWhileDist("Dist.distGraph: Пустой хранимый компонент при рекурсивном вызове BillServ.distNode()");
			} catch (NotFoundODNLimit e) {
				e.printStackTrace();
				throw new ErrorWhileDist("Dist.distGraph: Не найден лимит ОДН в счетчике ОДН, при вызове BillServ.distNode()");
			} catch (NotFoundNode e) {
				e.printStackTrace();
				throw new ErrorWhileDist("Dist.distGraph: Не найден нужный счетчик, при вызове BillServ.distNode(): ");
			}
			//Calc.showTimer(Calc.getCalcTp()+" тип");
			
			//break;
		}

		
	}



}
