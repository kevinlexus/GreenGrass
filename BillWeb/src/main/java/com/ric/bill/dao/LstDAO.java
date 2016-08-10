package com.ric.bill.dao;

import java.util.List;

import com.ric.bill.model.ar.House;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.bs.Serv;


public interface LstDAO {

	public Lst findByCD(String cd);
	
}
