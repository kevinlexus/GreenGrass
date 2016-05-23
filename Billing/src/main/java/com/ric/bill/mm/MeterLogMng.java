package com.ric.bill.mm;

import java.util.List;

import com.ric.bill.Storable;
import com.ric.bill.model.bs.Par;
import com.ric.bill.model.mt.MeterLog;

public interface MeterLogMng extends Manage{

	public List<MeterLog> findByTp(Storable o, String tp);

}