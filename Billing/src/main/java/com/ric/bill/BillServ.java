package com.ric.bill;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.mt.Meter;
import com.ric.bill.model.mt.MeterExs;
import com.ric.bill.model.mt.MeterLog;
import com.ric.bill.model.mt.MeterLogGraph;
import com.ric.bill.model.mt.Vol;

/**
 * Главный сервис биллинга
 * @author lev
 *
 */
@Service
public class BillServ {

	@Autowired
	private Calc calc;

	//EntityManager - EM нужен на каждый DAO или сервис свой!
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
		setFilters();//вкл.фильтр
		//найти необходимые дома
		long startTime = System.currentTimeMillis();
		
		for (House o: calc.getHouseMng().findAll()) {
			//задать текущие дом и город
			calc.setHouse(o);
			calc.setArea(calc.getHouse().getStreet().getArea());
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
	}
	
	/**
	 * Распределить объем по вводам дома
	 * @param calcTp - тип обработки
	 */
	@Transactional
	private void distHouseServTp(Serv serv) {
		//найти все вводы по дому и по услуге
		for (MeterLog ml : calc.getHouseMng().getMetLogByServTp(calc.getHouse(), serv, "Ввод")) {
			distGraph(ml);
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
			Calc.setGenDt(c.getTime());
			@SuppressWarnings("unused")
			NodeVol dummy;
			try {
				dummy=distNode(mLog, new NodeVol());
			} catch (WrongGetMethod e) {
				System.out.println("Ошибка при рекурсивном вызове BillServ.distNode()");
			}
			//System.out.println("Объём в итоге="+dummy.getVol()+" по типу="+calc.getCalcTp());
			//System.out.println("по дате="+calc.getGenDt());
		}
		
	}
	
	/**
	 * Распределить узел, следуя по графу (рекурсивная процедура)
	 * @param mLog
	 * @throws WrongGetMethod 
	 */
	private NodeVol distNode (MeterLog mLog, NodeVol nv) throws WrongGetMethod {
		if (nv.getRecur() > 1000) {
			throw new WrongGetMethod("При расчете счетчика MeterLog.Id="+mLog.getId()+" , обнаружен замкнутый цикл");
		}
		nv.addRecur();
		//System.out.println("Номер итерации:"+nv.getRecur());
		//System.out.println("Счетчик:id="+mLog.getId()+" тип="+mLog.getTp().getCd());
		String mLogTp = mLog.getTp().getCd(); //Тип лог счетчика
		if (calc.getCalcTp()==0) {
			//по расчетной связи
			if (mLogTp.equals("ЛИПУ") || mLogTp.equals("ЛОДПУ") || mLogTp.equals("ЛГрупп")) {
				//посчитать объемы, по физическим счетчикам, прикрепленным к узлу
			    //(если такие есть) в пропорции на кол-во дней объема
				for (Meter m : mLog.getMeter()) { 		//физ.сч
					for (Vol v : m.getVol()) {    		//фактические объемы
						if (v.getTp().getCd().equals("Фактический объем")) {
							for (MeterExs e : m.getExs()) { //периоды сущ.
								//добавить объем в объект объема
								//умножить объем на процент существования и на долю дня
								Double t=v.getVol1() * e.getPrc() / calc.getCntCurDays();
								if (t != 0) {
									//if (m.getId()==821719) {
									// System.out.println("Объём по счетчику id="+m.getId()+" доля="+t+" vol="+v.getVol1()+" за дату="+calc.getGenDt());
 									nv.addVol( t );
								}
								
							}
						}
					}
				}
			} else if (mLogTp.equals("ЛНрм")){
				//TODO сделать обработку норматива
				
			}
				
		} if (calc.getCalcTp()==1) {
			//по связи по площади и кол.прож.
		} if (calc.getCalcTp()==2 && mLogTp.equals("Лсчетчик")) {
			//по расчетной связи ОДН (только у лог.счетчиков, при наличии расчетной связи ОДН)
		} if (calc.getCalcTp()==3 && mLogTp.equals("Лсчетчик")) {
			//по расчетной связи пропорц.площади (Отопление например)
			
		}
		
		//найти все направления, с необходимым типом, указывающие в точку из других узлов, получить их объемы
		//System.out.println("Найдено входящих направлений ="+mLog.getDst().size());
		for (MeterLogGraph g : mLog.getDst()) {
			if (calc.getCalcTp()==0 && g.getTp().getCd().equals("Расчетная связь") 
			 || calc.getCalcTp()==1 && g.getTp().getCd().equals("Связь по площади и кол-во прож.")
			 || calc.getCalcTp()==2 && g.getTp().getCd().equals("Расчетная связь ОДН")
			 || calc.getCalcTp()==3 && g.getTp().getCd().equals("Расчетная связь пропорц.площади")) {
					distNode(g.getNodsrc(), nv);
			}
		}
		
		//счетчик рекурсии на -1
		nv.decRecur();
		return nv;
	}
}
