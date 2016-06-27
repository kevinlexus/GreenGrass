package com.ric.bill.mm;

import java.util.Date;
import java.util.List;

import com.ric.bill.MeterContains;
import com.ric.bill.SumNodeVol;
import com.ric.bill.Storable;
import com.ric.bill.excp.NotFoundNode;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.mt.MLogs;
import com.ric.bill.model.mt.MeterLog;

public interface MeterLogMng {

	public List<MLogs> getMetLogByServTp(MeterContains mm, Serv serv, String tp);
	public MLogs getFirstMetLogByServTp(MeterContains mm, Serv serv, String tp);
	public boolean checkExsMet(MLogs mLog, Date genDt);
    public SumNodeVol getVolPeriod (MLogs mLog, Date dt1, Date dt2);
	public MLogs getLinkedNode(MLogs lnkMLog, String string, Date genDt);
	public void delNodeVol(MLogs ml, int tp, Date genDt);

}