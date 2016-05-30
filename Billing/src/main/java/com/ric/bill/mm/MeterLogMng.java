package com.ric.bill.mm;

import java.util.List;

import com.ric.bill.LinkedNodeVol;
import com.ric.bill.Storable;
import com.ric.bill.excp.NotFoundNode;
import com.ric.bill.model.mt.MeterLog;

public interface MeterLogMng extends StorableMng{

    public LinkedNodeVol getVolPeriod (MeterLog mLog, String tp) throws NotFoundNode;
	public List<MeterLog> findByTp(Storable o, String tp);

}