package com.ric.bill.dao;

import java.util.List;
import java.util.Set;

import com.ric.bill.SumNodeVol;
import com.ric.bill.Storable;
import com.ric.bill.excp.NotFoundNode;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.mt.main.MLogs;
import com.ric.bill.model.mt.main.MLogsAbstract;
import com.ric.bill.model.mt.main.MeterLog;


public interface MeterLogDAO {
	public Kart getKart(int rqn, MLogsAbstract mLog);
	/*public House getHouse(MLogs mLog);*/
	
}
