package com.ric.bill.mm;

import java.util.Date;
import java.util.List;

import com.ric.bill.NodeVol;
import com.ric.bill.Storable;
import com.ric.bill.model.bs.Par;
import com.ric.bill.model.mt.MLogs;

public interface ParMng {

	boolean isExByCd(String cd);
	//public boolean checkPar(int id, String cd, String dataTp);
	public Par getByCD(String cd);
	public Double getDbl(Storable st, String cd, Date dt1);
	public Double getDbl(Storable st, String cd);
	public String getStr(Storable st, String cd, Date dt1);
	public String getStr(Storable st, String cd);

}