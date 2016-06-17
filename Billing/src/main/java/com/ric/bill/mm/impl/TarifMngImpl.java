package com.ric.bill.mm.impl;

import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.TarifContains;
import com.ric.bill.dao.KartDAO;
import com.ric.bill.dao.TarifDAO;
import com.ric.bill.mm.TarifMng;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.tr.TarifKlsk;
import com.ric.bill.model.tr.TarifServ;
import com.ric.bill.model.tr.TarifServOrg;
import com.ric.bill.model.tr.TarifServProp;

/**
 * Сервис работы с тарифами
 * @author lev
 *
 */
@Service
public class TarifMngImpl implements TarifMng {
	
	@Autowired
	private TarifDAO tDao;


	/**
	 * Получить значение типа Double тарифа по CD 
	 * @param tar - список записей тарифа по свойствам
	 * @param cd - код свойства
	 * @return - свойство
	 */
	public Double findProp(TarifContains tc, Serv serv, String cd) {
		return tDao.findProp(tc, serv, cd);
	}
}
