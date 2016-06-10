package com.ric.bill;

import java.util.Set;

import com.ric.bill.model.ps.Reg;
import com.ric.bill.model.ps.RegState;

/**
 * Интерфейс объектов содержащих регистрации проживающих
 * @author lev
 *
 */
public interface RegContains extends Storable {

	public Set<Reg> getReg();
	public void setReg(Set<Reg> reg);
	public Set<RegState> getRegState();
	public void setRegState(Set<RegState> regState);

}
