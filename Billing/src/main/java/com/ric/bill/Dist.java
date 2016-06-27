package com.ric.bill;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.excp.EmptyServ;
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
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.bs.Par;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.mt.MLogs;
import com.ric.bill.model.mt.Meter;
import com.ric.bill.model.mt.MeterExs;
import com.ric.bill.model.mt.MeterLog;
import com.ric.bill.model.mt.MeterLogGraph;
import com.ric.bill.model.mt.Vol;

/**
 * Сервис распределения объемов
 * @author lev
 *
 */
@Service
public class Dist {

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
	private void delHouseVolServ() {
		delHouseServVolTp(calc.getServ().getMet(), 1);
		delHouseServVolTp(calc.getServ().getMet(), 0);
		delHouseServVolTp(calc.getServ().getMet(), 2);
		delHouseServVolTp(calc.getServ().getMet(), 3);
		if (calc.getServ().getOdn() != null){
			delHouseServVolTp(calc.getServ().getOdn(), 0);//счетчики ОДН
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
			for (MLogs ml : metMng.getMetLogByServTp(calc.getHouse(), serv, "Ввод")) {
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

	/**
	 * распределить объем по дому
	 * @param houseId - Id дома, иначе кэшируется, если передавать объект дома
	 * @throws ErrorWhileDist 
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void distHouseVol(int houseId) throws ErrorWhileDist {
		
		calc.setUp(); //настроить даты и т.п.
		calc.clearLstChecks();//почистить рассчитанные объемы

		House h = em.find(House.class, houseId);
		if (!Calc.isInit()) {
			calc.setHouse(h);
			calc.setArea(calc.getHouse().getStreet().getArea());
			Calc.setInit(true);
		}
		Calc.mess("Распределение объемов");
		Calc.mess("Дом: id="+calc.getHouse().getId());
		Calc.mess("Дом: klsk="+calc.getHouse().getKlsk());

		
		/*Serv serv = servMng.findByCd("Холодная вода (объем)");	
		Calc.mess("услуга 1:"+serv.getName(), 2);
		serv = servMng.findByCd("Отопление ОДН");	
		Calc.mess("услуга 2:"+serv.getName(), 2);
		serv = servMng.findByCd("Холодная вода (объем)");	
		Calc.mess("услуга 3:"+serv.getName(), 2);*/
		
		//найти все необходимые услуги для удаления объемов
		for (Serv s : servMng.findForDistVol()) {
				calc.setServ(s);
				delHouseVolServ();
		}

		//найти все необходимые услуги для распределения
		try {
			for (Serv s : servMng.findForDistVol()) {
				calc.setServ(s);
				Calc.mess("Распределение услуги: "+s.getCd());
				  distHouseServ();
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
	private void distHouseServ() throws ErrorWhileDist {
		Calc.mess("******************Услуга*************="+calc.getServ().getCd(), 2);

		try { 
			calc.setCalcTp(1);
			distHouseServTp(calc.getServ().getMet());//Расчет площади, кол-во прожив
			calc.setCalcTp(0);
			distHouseServTp(calc.getServ().getMet());//Распределение объема
			calc.setCalcTp(2);
			distHouseServTp(calc.getServ().getMet());//Расчет ОДН
			calc.setCalcTp(3);
			distHouseServTp(calc.getServ().getMet());//Расчет пропорц.площади
			if (calc.getServ().getOdn() != null){
				calc.setCalcTp(0);
				distHouseServTp(calc.getServ().getOdn());//Суммировать счетчики ОДН
			}
		} catch (ErrorWhileDist e) {
			e.printStackTrace();
			throw new ErrorWhileDist("Dist.distHouseServ: ");
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
		try {
			for (MLogs ml : metMng.getMetLogByServTp(calc.getHouse(), serv, "Ввод")) {
					distGraph(ml);
			}
		} catch (ErrorWhileDist e) {
			e.printStackTrace();
			throw new ErrorWhileDist("Dist.distHouseServTp: ");
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
