package com.ric.bill.mm;

import java.util.List;

import com.ric.web.PeriodReportsDTO;

public interface ReportMng {
	
	public List<PeriodReportsDTO> getPeriodsByCD(String repCd, int tp);

}
