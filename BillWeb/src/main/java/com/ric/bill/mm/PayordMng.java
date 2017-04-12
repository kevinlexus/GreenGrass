package com.ric.bill.mm;

import java.util.List;

import com.ric.bill.dto.PayordCmpDTO;
import com.ric.bill.dto.PayordDTO;
import com.ric.bill.dto.PayordGrpDTO;
import com.ric.bill.model.fn.Payord;
import com.ric.bill.model.fn.PayordCmp;
import com.ric.bill.model.fn.PayordGrp;

public interface PayordMng {

	public List<PayordGrp> getPayordGrpAll();
	public void setPayordGrpDto(PayordGrpDTO payorGrpdDTO);
	public void delPayordGrpDto(PayordGrpDTO t);
	public PayordGrp addPayordGrpDto(PayordGrpDTO t);
	public PayordGrp getPayordGrpById(Integer id);
	public void refreshPayordGrp(PayordGrp p);

	public List<Payord> getPayordAll();
	public List<Payord> getPayordByPayordGrpId(Integer payordGrpId);
	public void setPayordDto(PayordDTO payordDTO);
	public void delPayordDto(PayordDTO t);
	public Payord addPayordDto(PayordDTO t);
	public void refreshPayord(Payord t);

	public List<PayordCmp> getPayordCmpByPayordId(Integer payordId);
	public void setPayordCmpDto(PayordCmpDTO t);
	public void delPayordCmpDto(PayordCmpDTO t);
	public PayordCmp addPayordCmpDto(PayordCmpDTO t);
	public void refreshPayordCmp(PayordCmp t);
	public void genPayord();
}
