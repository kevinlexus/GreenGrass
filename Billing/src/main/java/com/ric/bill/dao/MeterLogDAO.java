package com.ric.bill.dao;

import java.util.List;

import com.ric.bill.Storable;
import com.ric.bill.model.MeterLog;


public interface MeterLogDAO {

	public List<MeterLog> findByTp(Storable o, String tp); 
}
