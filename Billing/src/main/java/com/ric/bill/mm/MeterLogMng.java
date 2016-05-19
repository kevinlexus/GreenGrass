package com.ric.bill.mm;

import java.util.List;

import com.ric.bill.Storable;
import com.ric.bill.model.MeterLog;
import com.ric.bill.model.Par;

public interface MeterLogMng {

	public List<MeterLog> findByTp(Storable o, String tp);

}