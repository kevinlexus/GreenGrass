package com.ric.bill;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

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
	
	// id перерасчета
	private Integer changeId;
	
	public Integer getChangeId() {
		return changeId;
	}

	public void setChangeId(Integer changeId) {
		this.changeId = changeId;
	}

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
	
}
