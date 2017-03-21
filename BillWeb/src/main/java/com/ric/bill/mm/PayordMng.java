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
	public List<Payord> getPayordAll();
	public List<Payord> getPayordByPayordGrpId(Integer payordGrpId);
	public void savePayordDto(PayordDTO payordDTO);
	public void savePayordGrpDto(PayordGrpDTO payorGrpdDTO);
	public List<PayordCmp> getPayordCmpByPayordId(Integer payordId);
	public void savePayordCmpDto(PayordCmpDTO t);
	public void refreshPayordGrp(PayordGrp p);
	public void delPayordGrpDto(PayordGrpDTO t);
	public PayordGrp addPayordGrpDto(PayordGrpDTO t);
	public PayordGrp getPayordGrpById(Integer id);
}
