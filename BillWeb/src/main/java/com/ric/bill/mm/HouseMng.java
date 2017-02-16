package com.ric.bill.mm;

import java.util.List;

import com.ric.bill.MeterContains;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.mt.MeterLog;
import com.ric.bill.model.tr.Serv;

public interface HouseMng {
	
	public List<House> findAll();
	public List<House> findAll2(Integer houseId, Integer areaId);
	
}
