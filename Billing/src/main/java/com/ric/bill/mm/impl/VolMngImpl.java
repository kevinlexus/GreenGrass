package com.ric.bill.mm.impl;

import java.util.List;
import java.util.Set;

import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.BillServ;
import com.ric.bill.dao.HouseDAO;
import com.ric.bill.dao.ServDAO;
import com.ric.bill.dao.VolDAO;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.mm.HouseMng;
import com.ric.bill.mm.ServMng;
import com.ric.bill.mm.VolMng;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.ar.Kw;
import com.ric.bill.model.bs.Dw;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.mt.Vol;

@Service
public class VolMngImpl implements VolMng {

	@Autowired
	private VolDAO vDao;


}