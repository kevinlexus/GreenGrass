package com.ric.bill.mm;

import java.util.Date;
import java.util.List;

import com.ric.bill.NodeVol;
import com.ric.bill.Storable;
import com.ric.bill.excp.EmptyServ;
import com.ric.bill.excp.EmptyStorable;
import com.ric.bill.excp.WrongSetMethod;
import com.ric.bill.model.bs.Par;
import com.ric.bill.model.mt.MLogs;

public interface ParMng {

	boolean isExByCd(int rqn, String cd);
	//public boolean checkPar(int id, String cd, String dataTp);
	public Par getByCD(int rqn, String cd);
	public Boolean getBool(int rqn, Storable st, String cd, Date genDt) throws EmptyStorable;
	public Double getDbl(int rqn, Storable st, String cd, Date dt1) throws EmptyStorable;
	public Double getDbl(int rqn, Storable st, String cd) throws EmptyStorable;
	public String getStr(int rqn, Storable st, String cd, Date dt1) throws EmptyStorable;
	public String getStr(int rqn, Storable st, String cd) throws EmptyStorable;
	public Date getDate(int rqn, Storable st, String cd) throws EmptyStorable;
	public void setDate(int rqn, Storable st, String cd, Date dt) throws EmptyStorable, WrongSetMethod;

}