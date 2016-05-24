package com.ric.bill.mm.impl;

import java.util.List;
import java.util.Set;

import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.Dist;
import com.ric.bill.dao.HouseDAO;
import com.ric.bill.dao.ServDAO;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.mm.common.HouseMng;
import com.ric.bill.mm.common.ServMng;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.ar.Kw;
import com.ric.bill.model.bs.Dw;
import com.ric.bill.model.bs.Serv;

@Service
public class ServMngImpl extends BaseStore implements ServMng {

	@Autowired
	private ServDAO sDao;

	@Override
	@Transactional
	public List<Serv> findAll() {
		return sDao.findAll();
	}

	@Override
	public List<Serv> findForChrg() {
		return sDao.findForChrg();
	}


}