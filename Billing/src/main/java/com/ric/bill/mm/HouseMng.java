package com.ric.bill.mm;

import java.util.List;
import java.util.Set;

import com.ric.bill.MeterManagable;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.model.Dw;
import com.ric.bill.model.House;
import com.ric.bill.model.MeterLog;
import com.ric.bill.model.Serv;

public interface HouseMng {
	
	public List<House> findAll();
	public Double getDbl(Set<Dw> dw, String cd);
	public List<MeterLog> getMetLogByServTp(MeterManagable mm, Serv serv, String tp);
	
}
