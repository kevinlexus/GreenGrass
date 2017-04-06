package com.ric.bill.model.mt.main;

import java.util.Date;

import com.ric.bill.model.bs.Lst;

public interface Vols {

	public abstract Integer getId();

	public abstract void setId(Integer id);

	public abstract Date getDt1();

	public abstract void setDt1(Date dt1);

	public abstract Date getDt2();

	public abstract void setDt2(Date dt2);

	public abstract Lst getTp();

	public abstract void setTp(Lst tp);

	public abstract Double getVol1();

	public abstract void setVol1(Double vol1);

	public abstract Double getVol2();

	public abstract void setVol2(Double vol2);

	public abstract MLogsAbstract getMLog();

	public abstract void setMLog(MeterLog ml);

	public abstract Meter getMet();

	public abstract void setMet(Meter met);

	public abstract Integer getStatus();

	public abstract void setStatus(Integer status);

	public abstract boolean equals(Object o);

	public abstract int hashCode();
}
