package com.ric.bill.mm.impl;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.Dist;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.mm.ParMng;
import com.ric.bill.model.Dw;

/**
 * Базовый класс сервиса хранимых объектов 
 * @author lev
 *
 */
public abstract class BaseStorableMng {

	@Autowired 
    private SessionFactory sessionFactory;
	
	/**
	 * получить значение параметра типа Double объекта по CD свойства
	 */
	@Transactional
	public Double getDbl(Set<Dw> dw, String cd) throws WrongGetMethod {
		Session session = sessionFactory.getCurrentSession();
		session.enableFilter("FILTER1").setParameter("TESTCASENAME", "1%");
		
		for (Dw d: dw) {
			//проверка, что соответствует CD и Number (NM), Единичное (SI)
			if (d.getPar().getCd().equals(cd)) {
				if (d.getPar().getTp().equals("NM")) {
					if (d.getPar().getDataTp().equals("SI")) {
						return d.getN1();
					} else {
						throw new WrongGetMethod("Попытка получить параметр "+cd+" не являющийся типом данного SI завершилась ошибкой");
					}
				} else {
					throw new WrongGetMethod("Попытка получить параметр "+cd+" не являющийся типом NM завершилась ошибкой");
				}
			}
		}
		//если не найдено, то проверить, существует ли вообще этот параметр, в природе
		ParMng p = (ParMng)Dist.ctx.getBean("parMngImpl");
		if (!p.isExByCd(cd)) {
			throw new WrongGetMethod("Параметр "+cd+" не существует в базе данных");
		};
		return null;
	}

}
