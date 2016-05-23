package com.ric.bill.mm;

import java.util.Set;

import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.ps.Reg;
import com.ric.bill.model.ps.RegState;
import com.ric.bill.model.ps.Registrable;

public interface KartMng {

	public int getCntPers(Serv serv, Set<Registrable> reg, Set<Registrable> regSt);


}