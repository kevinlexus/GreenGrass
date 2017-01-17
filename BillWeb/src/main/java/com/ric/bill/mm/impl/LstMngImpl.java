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
import com.ric.bill.dao.HouseDAO;
import com.ric.bill.dao.LstDAO;
import com.ric.bill.dao.ServDAO;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.mm.HouseMng;
import com.ric.bill.mm.LstMng;
import com.ric.bill.mm.ServMng;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.ar.Kw;
import com.ric.bill.model.bs.Dw;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.bs.Serv;

@Service
public class LstMngImpl implements LstMng {

	@Autowired
	private LstDAO lstDao;

	@Cacheable("neverWipe") //здесь кэш работает очень эффективно!
	public /*synchronized*/ Lst getByCD(String cd) {
		return lstDao.getByCD(cd);
	}


}