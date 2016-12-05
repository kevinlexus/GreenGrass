package com.ric.bill;

import com.ric.bill.model.fn.Chng;

/**
 * Конфиг запроса
 * @author lev
 *
 */
public class RequestConfig {
	// операция (0-начисление, 1-перерасчет)
	private Integer oper;

	// включить распределение?
	private Boolean isDist;
	
	// перерасчет
	private Chng chng;
	
	public Integer getOper() {
		return oper;
	}

	public void setOper(Integer operTp) {
		this.oper = operTp;
	}

	public Boolean getIsDist() {
		return isDist;
	}

	public void setIsDist(Boolean isDist) {
		this.isDist = isDist;
	}

	public Chng getChng() {
		return chng;
	}

	public void setChng(Chng chng) {
		this.chng = chng;
	}
	
}
