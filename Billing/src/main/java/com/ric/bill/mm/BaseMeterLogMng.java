package com.ric.bill.mm;

import java.util.List;

import com.ric.bill.MeterContains;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.mt.MLogs;
import com.ric.bill.model.mt.MeterLog;

public interface BaseMeterLogMng extends StorableMng {
	public abstract MLogs getFirstMetLogByServTp(MeterContains mm, Serv serv, String tp);
	public List<MLogs> getMetLogByServTp(MeterContains mm, Serv serv, String tp);

	
}
