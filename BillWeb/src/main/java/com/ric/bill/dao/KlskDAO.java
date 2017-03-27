package com.ric.bill.dao;

import java.util.List;

import com.ric.bill.model.ar.House;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.oralv.Klsk;
import com.ric.bill.model.tr.Serv;


public interface KlskDAO {

	public Klsk getByKlsk(Integer klsk);
	
}
