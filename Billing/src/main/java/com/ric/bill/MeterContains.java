package com.ric.bill;

import java.util.List;
import java.util.Set;

import com.ric.bill.model.mt.MeterLog;

public interface MeterContains extends Storable {
	public Set<MeterLog> getMlog();
	public void setMlog(Set<MeterLog> mlog);
}
