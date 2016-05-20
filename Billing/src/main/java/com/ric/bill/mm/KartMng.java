package com.ric.bill.mm;

import java.util.Set;

import com.ric.bill.model.ps.Reg;
import com.ric.bill.model.ps.RegState;

public interface KartMng {

	public int getCntPers(Set<Reg> reg, Set<RegState> regSt);


}