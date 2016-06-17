package com.ric.bill.mm;

import java.util.Set;

import com.ric.bill.Calc;
import com.ric.bill.CntPers;
import com.ric.bill.MeterContains;
import com.ric.bill.RegContains;
import com.ric.bill.Standart;
import com.ric.bill.TarifContains;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.mt.MLogs;
import com.ric.bill.model.mt.MeterLog;
import com.ric.bill.model.tr.TarifKlsk;

public interface KartMng  {

	public abstract void getCntPers(RegContains rc, Serv serv, CntPers cntPers, int tp);
	public abstract Double getServPropByCD(Kart kart, Serv serv, String string);
	public abstract Standart getStandart(MLogs mLog, Calc calc, CntPers cntPers);

}