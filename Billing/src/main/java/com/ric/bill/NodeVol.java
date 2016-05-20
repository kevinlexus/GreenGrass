package com.ric.bill;

/**
 * Текущий расчет по узлу 
 * @author lev
 *
 */
public class NodeVol {

	// значения за расчетный период:
	private Double vol;// объем
	private Double area;// доля площади
	private Double pers;// доля проживающих
	
	private int recur;// счетчик рекурсии

	public NodeVol(){
		vol  = new Double(0);
		area = new Double(0);
		pers = new Double(0);
		setRecur(0);
	}
	
	// рекурсия +1
	public void addRecur() {
		setRecur(getRecur() + 1);
	}

	// рекурсия -1
	public void decRecur() {
		setRecur(getRecur() - 1);
	}

	public Double getVol() {
		return vol;
	}
	
	public void setVol(Double vol) {
		this.vol = vol;
	}
	
	public void addVol(Double vol) {
		this.vol = this.vol+vol;
	}

	public Double getArea() {
		return area;
	}
	
	public void setArea(Double area) {
		this.area = area;
	}
	
	public Double getPers() {
		return pers;
	}
	
	public void setPers(Double pers) {
		this.pers = pers;
	}

	public int getRecur() {
		return recur;
	}

	public void setRecur(int recur) {
		this.recur = recur;
	}
	
}
