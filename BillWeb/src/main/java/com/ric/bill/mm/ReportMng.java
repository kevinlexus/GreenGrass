package com.ric.bill.mm;

import java.util.List;

import com.ric.web.PeriodReportsWeb;

public interface ReportMng {
	
	public List<PeriodReportsWeb> getPeriodsByCD(String repCd, int tp);

}
