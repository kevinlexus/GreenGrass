package com.ric.bill.dao;

import java.util.List;

import com.ric.bill.model.ar.House;
import com.ric.bill.model.bs.Serv;


public interface ServDAO {

	public Serv findMain(Serv serv);
	public List<Serv> findForDistVol();
	public List<Serv> findForDistVolForKart();
	public Serv getByCD(String cd);	
}
