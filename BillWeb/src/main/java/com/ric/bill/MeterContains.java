package com.ric.bill;

import java.util.List;
import java.util.Set;

import com.ric.bill.model.mt.main.MLogs;
import com.ric.bill.model.mt.main.MeterLog;

public interface MeterContains extends Storable {
	public List<MeterLog> getMlog();
	public void setMlog(List<MeterLog> mlog);
}
