package com.ric.bill;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.model.House;
import com.ric.bill.model.MeterLog;
import com.ric.bill.model.Serv;

/**
 * Главный сервис биллинга
 * @author lev
 *
 */
@Service
public class BillServ {

	@Autowired
	private Calc calc;

	// EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;

    /**
	 * Установить фильтры для сессии
	 */
	@Transactional(propagation=Propagation.MANDATORY)
	private void setFilters() {
		Session session = (Session) em.getDelegate();
		session.enableFilter("FILTER_GEN_DT").setParameter("DT1", Calc.getGenDt());
	}

	/**
	 * распределить объем по фонду
	 */
	@Transactional
	public void distVols() {
		System.out.println("1");
		calc.setUp(); //настроить
		setFilters();// вкл.фильтр
		// найти необходимые дома
		long startTime = System.currentTimeMillis();
		
		for (House o: calc.getHouseMng().findAll()) {
			calc.setHouse(o);
			distHouseVols();
		}		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Время исполнения:"+totalTime);
	}

	/**
	 * распределить объем по дому
	 */
	@Transactional
	public void distHouseVols() {
		System.out.println("Дом: id="+calc.getHouse().getId());
		System.out.println("Дом: klsk="+calc.getHouse().getKlsk());
		System.out.println("Площадь: "+calc.getHouseMng().getDbl(calc.getHouse().getDw(), "Площадь.Жилая"));
		//найти все необходимые услуги для распределения
		for (Serv s : calc.getServMng().findForChrg()) {
			calc.setServ(s);
			distHouseServ();
		}
	}
	
	/**
	 * распределить объем по услуге данного дома
	 */
	@Transactional
	private void distHouseServ() {
		System.out.println("Услуга="+calc.getServ().getCd());
		calc.setCalcTp(1);
		distHouseServTp(calc.getServ());// Расчет площади, кол-во прожив
		calc.setCalcTp(0);
		distHouseServTp(calc.getServ());// Распределение объема
		calc.setCalcTp(2);
		distHouseServTp(calc.getServ());// Расчет ОДН
		calc.setCalcTp(3);
		distHouseServTp(calc.getServ());// Расчет пропорц.площади
		if (calc.getServOdn() != null){
			calc.setCalcTp(0);
			distHouseServTp(calc.getServOdn());// Суммировать счетчики ОДН
		}
		
	}
	
	/**
	 * Распределить объем по вводам дома
	 * @param calcTp - тип обработки
	 */
	@Transactional
	private void distHouseServTp(Serv serv) {
		//найти все вводы по дому и по услуге
		for (int a=0; a<1; a++) {

			for (MeterLog ml : calc.getHouseMng().getMetLogByTp(calc.getHouse(), "Ввод")) {
				distGraph(ml);
				break;
			}
			/*for (MeterLog ml : calc.getMetLogMng().findByTp(calc.getHouse(), "Ввод")){
				//System.out.println("Ввод: id="+ml.getId());
				//distGraph(ml);
			}*/
			//System.out.println(a);
		}
	}
	
	/**
	 * Распределить граф начиная с mLog
	 * @param mLog - начальный узел распределения
	 */
	private void distGraph (MeterLog mLog) {
		
		//перебрать все даты, за период
		Calendar c = Calendar.getInstance();
		c.setTime(Calc.getCurDt1());
		for (c.setTime(Calc.getCurDt1()); !c.getTime().after(Calc.getCurDt2()); c.add(Calendar.DATE, 1)) {
			System.out.println(c.getTime());
			
		}
		/*while (!c.getTime().after(Calc.getCurDt2()))
	    {
			
			System.out.println(c.getTime());
			c.add(Calendar.DATE, 1);
	    }*/
		
	}
}
