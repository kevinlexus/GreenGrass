package com.ric.bill.mm;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.ric.bill.Calc;
import com.ric.bill.dto.PayordCmpDTO;
import com.ric.bill.dto.PayordDTO;
import com.ric.bill.dto.PayordFlowDTO;
import com.ric.bill.dto.PayordGrpDTO;
import com.ric.bill.excp.WrongDate;
import com.ric.bill.model.fn.Payord;
import com.ric.bill.model.fn.PayordCmp;
import com.ric.bill.model.fn.PayordFlow;
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

	public List<PayordFlow> getPayordFlowByTpPeriod(Integer tp, String period);
	public List<PayordFlow> getPayordFlowByTpDt(Integer tp, Date dt);
	public void setPayordFlowDto(PayordFlowDTO p);

	public void genPayord(Date genDt, Boolean isFinal, Boolean isEndMonth) throws WrongDate, ParseException;
	public PayordFlow getInsal(Payord p, String period, Integer tp);
	public BigDecimal getInsalSumm(Payord p, String period, Integer tp);	
	public void delPayordFlowDto(PayordFlowDTO t);
	public PayordFlow addPayordFlowDto(PayordFlowDTO t);
	public void refreshPayordFlow(PayordFlow t);
}
