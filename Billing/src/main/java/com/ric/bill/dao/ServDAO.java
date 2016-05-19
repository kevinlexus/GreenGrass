package com.ric.bill.dao;

import java.util.List;

import com.ric.bill.model.House;
import com.ric.bill.model.Serv;


public interface ServDAO {

	public List<Serv> findAll();
	public List<Serv> findForChrg();
	public Serv getMetServ(Serv s);
	public Serv getOdnServ(Serv s);
	
}
