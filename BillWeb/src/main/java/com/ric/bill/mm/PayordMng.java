package com.ric.bill.mm;

import java.util.List;

import com.ric.bill.dto.PayordDTO;
import com.ric.bill.model.fn.Payord;

public interface PayordMng {

	public List<Payord> getPayordAll();
	public void savePayordDto(PayordDTO payordDTO);
}