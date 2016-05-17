package com.ric.bill;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.mm.HouseMng;
import com.ric.bill.model.Dw;
import com.ric.bill.model.House;
import com.ric.bill.model.TarifKlsk;

/**
 * Главный сервис биллинга
 * @author lev
 *
 */
@Service
public class BillServ {

	@Autowired 
    private SessionFactory sessionFactory;

	Calc calc;	
	/**
	 * Установить фильтры для сессии
	 */
	@Transactional(propagation=Propagation.MANDATORY)
	public void setFilters() {
		Session session = sessionFactory.getCurrentSession();
		session.enableFilter("FILTER_GEN_DT").setParameter("DT1", Calc.getGenDt());
	}

	/**
	 * распределить объем по фонду
	 */
	@Transactional
	public void distVols() {

		calc = new Calc(); // объект для хранения параметров расчета
		// задать сервис дома
		calc.setHouseMng((HouseMng)Dist.ctx.getBean("houseMngImpl"));
		// найти необходимые дома
		for (House o: calc.getHouseMng().findAll()) {
			distHouseVols(o);
		}		
	}
	/**
	 * распределить объем по дому
	 */
	@Transactional
	public void distHouseVols(House house) {
		
		calc.setUp(); //настроить
		
		setFilters();// вкл.фильтр
		
		System.out.println("Дом: id="+house.getId());
		System.out.println("Дом: klsk="+house.getKlsk());
		try {
			System.out.println("Площадь: "+calc.getHouseMng().getDbl(house.getDw(), "Площадь.Жилая"));
		} catch (WrongGetMethod e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (TarifKlsk tar: house.getTarklsk()) {
			System.out.println("тариф: "+tar.getId() );
		}

		System.out.println("id="+house.getId()+" klsk="+house.getKlsk());
		System.out.println("тест="+house.getDw());
		for (Dw dw: house.getDw()) {
			System.out.println("Выбран параметр:"+dw.getPar().getCd());
			
		}    		
	}
}
