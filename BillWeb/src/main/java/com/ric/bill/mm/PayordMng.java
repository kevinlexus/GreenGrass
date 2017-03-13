package com.ric.bill.mm;

import java.util.List;

import com.ric.bill.dto.PayordDTO;
import com.ric.bill.model.fn.Payord;
import com.ric.bill.model.fn.PayordCmp;
import com.ric.bill.model.fn.PayordGrp;

public interface PayordMng {

	public List<PayordGrp> getPayordGrpAll();
	public List<Payord> getPayordAll();
	public void savePayordDto(PayordDTO payordDTO);
	public List<PayordCmp> getPayordCmpByPayordId(Integer payordId);
}
