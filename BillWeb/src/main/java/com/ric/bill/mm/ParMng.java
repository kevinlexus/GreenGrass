package com.ric.bill.mm;

import java.util.Date;
import java.util.List;

import com.ric.bill.Calc;
import com.ric.bill.NodeVol;
import com.ric.bill.Storable;
import com.ric.bill.excp.EmptyServ;
import com.ric.bill.excp.EmptyStorable;
import com.ric.bill.model.bs.Par;
import com.ric.bill.model.mt.MLogs;

public interface ParMng {

	boolean isExByCd(Calc calc, String cd);
	public Par getByCD(Calc calc, String cd);
	public Boolean getBool(Calc calc, Storable st, String cd, Date genDt) throws EmptyStorable;
	public Double getDbl(Calc calc, Storable st, String cd, Date dt1) throws EmptyStorable;
	public Double getDbl(Calc calc, Storable st, String cd) throws EmptyStorable;
	public String getStr(Calc calc, Storable st, String cd, Date dt1) throws EmptyStorable;
	public String getStr(Calc calc, Storable st, String cd) throws EmptyStorable;
	public Date getDate(Calc calc, Storable st, String cd) throws EmptyStorable;

}