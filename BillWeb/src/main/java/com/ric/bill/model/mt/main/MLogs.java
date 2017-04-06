package com.ric.bill.model.mt.main;

import java.util.List;

import com.ric.bill.Simple;
import com.ric.bill.Storable;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.tr.Serv;

public interface MLogs<Units extends Vols> extends Storable, Simple, MLogsAbstract {



	public abstract List<Units> getVol();

	public abstract void setVol(List<Units> vol);




}