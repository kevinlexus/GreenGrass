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
import com.ric.bill.model.Meter;
import com.ric.bill.model.MeterLog;
import com.ric.bill.model.Serv;
import com.ric.bill.model.Vol;

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
			//задать текущие дом и город
			Calc.setHouse(o);
			Calc.setArea(Calc.getHouse().getStreet().getArea());
			//распределить
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
		System.out.println("Дом: id="+Calc.getHouse().getId());
		System.out.println("Дом: klsk="+Calc.getHouse().getKlsk());
		System.out.println("Площадь: "+Calc.getHouseMng().getDbl(Calc.getHouse().getDw(), "Площадь.Жилая"));
		//найти все необходимые услуги для распределения
		for (Serv s : Calc.getServMng().findForChrg()) {
			Calc.setServ(s);
			distHouseServ();
		}
	}
	
	/**
	 * распределить объем по услуге данного дома
	 */
	@Transactional
	private void distHouseServ() {
		System.out.println("Услуга="+Calc.getServ().getCd());
		Calc.setCalcTp(1);
		distHouseServTp(Calc.getServ());// Расчет площади, кол-во прожив
		Calc.setCalcTp(0);
		distHouseServTp(Calc.getServ());// Распределение объема
		Calc.setCalcTp(2);
		distHouseServTp(Calc.getServ());// Расчет ОДН
		Calc.setCalcTp(3);
		distHouseServTp(Calc.getServ());// Расчет пропорц.площади
		if (Calc.getServOdn() != null){
			Calc.setCalcTp(0);
			distHouseServTp(Calc.getServOdn());// Суммировать счетчики ОДН
		}
		
	}
	
	/**
	 * Распределить объем по вводам дома
	 * @param calcTp - тип обработки
	 */
	@Transactional
	private void distHouseServTp(Serv serv) {
		//найти все вводы по дому и по услуге
		for (MeterLog ml : Calc.getHouseMng().getMetLogByTp(Calc.getHouse(), "Ввод")) {
			distGraph(ml);
			break;
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
			//System.out.println(c.getTime());
			NodeVol dummy;
			dummy=distNode(mLog, new NodeVol());
		}
		
	}
	
	/**
	 * Распределить узел, следуя по графу (рекурсивная процедура)
	 * @param mLog
	 */
	private NodeVol distNode (MeterLog mLog, NodeVol nv) {
		System.out.println("Счетчик:id="+mLog.getId()+" тип="+mLog.getTp().getCd());
		String mLogTp = mLog.getTp().getCd(); //Тип лог счетчика
		if (Calc.getCalcTp()==0) {
			//по расчетной связи
			if (mLogTp.equals("ЛИПУ") || mLogTp.equals("ЛОДПУ") || mLogTp.equals("ЛГрупп")) {
				//посчитать объемы, по физическим счетчикам, прикрепленным к узлу
			    //(если такие есть) в пропорции на кол-во дней объема
				for (Meter m : mLog.getMeter()) {
					for (Vol v : m.getVol()) {
						nv.addVol(v.getVol1());
						System.out.println("Объём ="+v.getVol1());
					}
				}
			}
				
		} if (Calc.getCalcTp()==1) {
			//по связи по площади и кол.прож.
		} if (Calc.getCalcTp()==2 && mLogTp.equals("Лсчетчик")) {
			//по расчетной связи ОДН (только у лог.счетчиков, при наличии расчетной связи ОДН)
		} if (Calc.getCalcTp()==3 && mLogTp.equals("Лсчетчик")) {
			//по расчетной связи пропорц.площади (Отопление например)
			
		}
		
		return nv;
	}
}
