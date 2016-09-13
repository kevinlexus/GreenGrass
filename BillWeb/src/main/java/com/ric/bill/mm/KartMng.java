package com.ric.bill.mm;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.ric.bill.Calc;
import com.ric.bill.CntPers;
import com.ric.bill.MeterContains;
import com.ric.bill.RegContains;
import com.ric.bill.Standart;
import com.ric.bill.TarifContains;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.bs.Org;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.mt.MLogs;
import com.ric.bill.model.mt.MeterLog;
import com.ric.bill.model.tr.TarifKlsk;

public interface KartMng  {

	public abstract void getCntPers(RegContains rc, Serv serv, CntPers cntPers, int tp, Date genDt);
	public abstract Double getServPropByCD(Kart kart, Serv serv, String string, Date genDt);
	public abstract Standart getStandart(Kart kart, Serv serv, CntPers cntPers, Date genDt);
	public Org getOrg(Kart kart, Serv serv, Date genDt);
	public List<Serv> getAllServ(Kart kart);
	public double getCapPrivs(RegContains rc, Date genDt);
	public boolean getServ(Kart kart, Serv serv, Date genDt);
	public List<Kart> findAll();
}