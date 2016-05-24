package com.ric.bill.mm;

import java.util.Set;

import com.ric.bill.CntPers;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.ps.Reg;
import com.ric.bill.model.ps.RegState;
import com.ric.bill.model.ps.Registrable;

public interface KartMng extends Manage {

	void getCntPers(Serv serv, CntPers cntPers, int tp);


}