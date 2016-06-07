package com.ric.bill;

import com.ric.bill.model.mt.MeterLog;

/**
 * Объем по связанному узлу 
 * @author lev
 *
 */
public class LinkedNodeVol {

	//значения за расчетный период:
	private Double vol;//объем
	private Double area;//площадь
	private Double pers;//проживающие
	
	public LinkedNodeVol(){
		setVol(new Double(0));
		setArea(new Double(0));
		setPers(new Double(0));
	}

	public Double getVol() {
		return vol;
	}

	public void setVol(Double vol) {
		this.vol = vol;
	}

	//добавить объем
	public void addVol(Double vol) {
		this.vol=this.vol+Utl.nvl(vol, 0.0); 
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	//добавить площадь
	public void addArea(Double area) {
		this.area=this.area+Utl.nvl(area, 0.0); 
	}

	public Double getPers() {
		return pers;
	}

	public void setPers(Double pers) {
		this.pers = pers;
	}
	
	//добавить кол-во проживающих
	public void addPers(Double pers) {
		this.pers=this.pers+Utl.nvl(pers, 0.0); 
	}

}
