package com.ric.bill;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.ric.bill.model.fn.Chng;

/**
 * Конфиг запроса
 * @author lev
 *
 */
public class RequestConfig {
	// тип операции (0-начисление, 1-перерасчет)
	private Integer operTp;

	// включить распределение?
	private Boolean isDist;
	
	// перерасчет
	private Chng chng;
	
	public Integer getOperTp() {
		return operTp;
	}

	public void setOperTp(Integer operTp) {
		this.operTp = operTp;
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
