package com.ric.bill.mm;

import java.util.List;
import java.util.Set;

import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.bs.Serv;

public interface LstMng {
	
    public List<Lst> findAll();
	public Lst findByCD(String cd);
	
}
