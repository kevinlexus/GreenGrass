package com.ric.bill.dao;

import java.util.List;

import com.ric.bill.model.ar.House;
import com.ric.bill.model.bs.Serv;


public interface ServDAO {

	public List<Serv> getAll();
	public Serv findMain(Serv serv);
	public List<Serv> findForDistVol();
	public Serv findByCd(String cd);	
}
