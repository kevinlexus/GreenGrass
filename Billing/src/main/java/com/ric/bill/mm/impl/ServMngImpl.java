package com.ric.bill.mm.impl;

import java.util.List;
import java.util.Set;

import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.BillServ;
import com.ric.bill.Calc;
import com.ric.bill.dao.HouseDAO;
import com.ric.bill.dao.ServDAO;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.mm.HouseMng;
import com.ric.bill.mm.ServMng;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.ar.Kw;
import com.ric.bill.model.bs.Dw;
import com.ric.bill.model.bs.Serv;

@Service
public class ServMngImpl implements ServMng {

	@Autowired
	private ServDAO sDao;

	
	//да, да, кэш на уровне DAO! (быстрее работает)
	//@Cacheable(cacheNames="readOnlyCache", key="{ #serv.getId() }") 
	public synchronized Serv findMain(Serv serv) {
		return sDao.findMain(serv);
	}

	//@Cacheable(cacheNames="readOnlyCache")
	public synchronized List<Serv> findForDistVol() {
		return sDao.findForDistVol();
	}

	//@Cacheable(cacheNames="readOnlyCache", key="{ #cd }")
	public synchronized Serv findByCd(String cd) {
		//Calc.mess("################### ПРОВЕРКА КЭША ####################",2);
		return sDao.findByCd(cd);
	}

}