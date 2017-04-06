package com.ric.bill.mm;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.ric.bill.Calc;
import com.ric.bill.MeterContains;
import com.ric.bill.SumNodeVol;
import com.ric.bill.Storable;
import com.ric.bill.excp.NotFoundNode;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.mt.main.MLogs;
import com.ric.bill.model.mt.main.MLogsAbstract;
import com.ric.bill.model.mt.main.MeterLog;
import com.ric.bill.model.tr.Serv;

public interface MeterLogMng {

	public List<MLogsAbstract> getAllMetLogByServTp(int rqn, MeterContains mm, Serv serv, String tp);
	public boolean checkExsKartMet(int rqn, Kart kart, Serv serv, Date genDt);
	public boolean checkExsMet(int rqn, MLogsAbstract mLog, Date genDt);
    public SumNodeVol getVolPeriod (int rqn, Integer statusVol, MLogsAbstract mLog, int tp, Date dt1, Date dt2);
	public SumNodeVol getVolPeriod (int rqn, Integer statusVol, MeterContains mc, Serv serv, Date dt1, Date dt2);
	public MLogsAbstract getLinkedNode(int rqn, MLogsAbstract lnkMLog, String string, Date genDt);
	public void delNodeVol(int rqn, MLogsAbstract ml, int tp, Date dt1, Date dt2, Integer status);
	public Kart getKart(int rqn, MLogsAbstract mLog);

}