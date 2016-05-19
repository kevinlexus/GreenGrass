package com.ric.bill;

import java.math.BigDecimal;

/**
 * Текущий расчет по узлу 
 * @author lev
 *
 */
public class NodeVol {

	// значения за расчетный период:
	private BigDecimal vol;// объем
	private BigDecimal area;// доля площади
	private BigDecimal pers;// доля проживающих
	
	public NodeVol(){
		vol  = new BigDecimal(0);
		area = new BigDecimal(0);
		pers = new BigDecimal(0);
	}
	
	public BigDecimal getVol() {
		return vol;
	}
	
	public void setVol(BigDecimal vol) {
		this.vol = vol;
	}
	
	public void addVol(BigDecimal vol) {
		this.vol = this.vol.add(vol);
	}

	public BigDecimal getArea() {
		return area;
	}
	
	public void setArea(BigDecimal area) {
		this.area = area;
	}
	
	public BigDecimal getPers() {
		return pers;
	}
	
	public void setPers(BigDecimal pers) {
		this.pers = pers;
	}
	
}
