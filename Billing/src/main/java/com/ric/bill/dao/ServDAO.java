package com.ric.bill.dao;

import java.util.List;

import com.ric.bill.model.ar.House;
import com.ric.bill.model.bs.Serv;


public interface ServDAO {

	public List<Serv> findAll();
	public List<Serv> findForChrg();
	
}
