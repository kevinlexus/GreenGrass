package com.ric.bill;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.mm.HouseMng;
import com.ric.bill.mm.ServMng;
import com.ric.bill.model.Dw;
import com.ric.bill.model.House;
import com.ric.bill.model.MeterLog;
import com.ric.bill.model.Serv;
import com.ric.bill.model.TarifKlsk;

/**
 * Главный сервис биллинга
 * @author lev
 *
 */
@Service
public class BillServ {

//	@Autowired 
    //private SessionFactory sessionFactory;

	Calc calc;

	@Autowired
    private HouseMng houseMng;
	
	@Autowired
    private ServMng servMng;

	protected EntityManager em;
	 
    public EntityManager getEntityManager() {
        return em;
    }
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }
	
	/**
	 * Установить фильтры для сессии
	 */
	@Transactional(propagation=Propagation.MANDATORY)
	public void setFilters() {
		Session session = (Session) em.getDelegate();
		session.enableFilter("FILTER_GEN_DT").setParameter("DT1", Calc.getGenDt());
	}

	/**
	 * распределить объем по фонду
	 */
	@Transactional
	public void distVols() {
		System.out.println("1");


		calc = new Calc(); // объект для хранения параметров расчета
		calc.setUp(); //настроить
		setFilters();// вкл.фильтр
		// задать сервис дома
		calc.setHouseMng(houseMng);
		// задать сервис услуг
		calc.setServMng(servMng);
		// найти необходимые дома
		for (House o: calc.getHouseMng().findAll()) {
			calc.setHouse(o);
			distHouseVols();
		}		
		System.out.println("2");
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
	public void distHouseServ() {
		System.out.println("Услуга="+calc.getServ().getName());
		/*distHouseServTp(1);// Расчет площади, кол-во прожив
		distHouseServTp(0);// Распределение объема
		distHouseServTp(2);// Расчет ОДН
		distHouseServTp(3);// Расчет пропорц.площади
		distHouseServTp(0);// Суммировать счетчики ОДН
		*/
	}
	
	/**
	 * Распределить объем по типу обработки связи
	 * @param serv - услуга, которую распределить 
	 * @param calcTp - тип обработки
	 */
	@Transactional
	public void distHouseServTp(Serv serv, int calcTp) {
		System.out.println("Услуга="+calc.getServ().getName());
		
		
	}
	
}
