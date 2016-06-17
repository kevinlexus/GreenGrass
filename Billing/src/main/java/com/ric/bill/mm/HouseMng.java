package com.ric.bill.mm;

import java.util.List;

import com.ric.bill.MeterContains;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.mt.MeterLog;

public interface HouseMng {
	
	public List<House> findAll();
	
}
