package com.ric.bill.mm;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.ric.bill.MeterContains;
import com.ric.bill.SumNodeVol;
import com.ric.bill.Storable;
import com.ric.bill.excp.NotFoundNode;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.mt.MLogs;
import com.ric.bill.model.mt.MeterLog;

public interface MeterLogMng {

	public List<MLogs> getAllMetLogByServTp(MeterContains mm, Serv serv, String tp);
	public boolean checkExsMet(MLogs mLog, Date genDt);
    public SumNodeVol getVolPeriod (MLogs mLog, int tp, Date dt1, Date dt2);
	public SumNodeVol getVolPeriod (MeterContains mc, Serv serv, Date dt1, Date dt2);
	public MLogs getLinkedNode(MLogs lnkMLog, String string, Date genDt);
	public void delNodeVol(MLogs ml, int tp, Date dt1, Date dt2);
	public Kart getKart(MLogs mLog);
	//public House getHouse(MLogs mLog);

}