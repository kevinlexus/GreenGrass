package com.ric.bill.mm.impl;

import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.TarifContains;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.tr.TarifKlsk;
import com.ric.bill.model.tr.TarifServ;
import com.ric.bill.model.tr.TarifServOrg;
import com.ric.bill.model.tr.TarifServProp;

/**
 * Абстрактный класс сервисов, умеющих работать с тарифами
 * @author lev
 *
 */

public abstract class TarifStore extends BaseStore {
	
	
	/**
	 * Получить значение типа Double тарифа по CD 
	 * @param tar - список записей тарифа по свойствам
	 * @param cd - код свойства
	 * @return - свойство
	 */
	public Double findProp(TarifContains tc, Serv serv, String cd) {
		//искать сперва по наборам тарифа объекта 
		//Hibernate.initialize(tc.getTarklsk()); 
		System.out.println("CHECK5");
		System.out.println("CHECK6");
		for (TarifKlsk k : tc.getTarifklsk()) {
			System.out.println("k="+k.getId());
			//затем по строкам - составляющим тариф 

			for (TarifServProp t : k.getTarprop()) {
				System.out.println("t="+k.getId());
				if (t.getServ().equals(serv) && t.getProp().getCd().equals(cd)) {
					return t.getN1();
				}
			}

		}
		return null;
		
	}
}
