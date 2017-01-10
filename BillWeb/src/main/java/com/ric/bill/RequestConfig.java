package com.ric.bill;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.ric.bill.model.fn.Chng;

/**
 * Конфиг запроса
 * @author lev
 *
 */
@Slf4j
public class RequestConfig {
	// тип операции (0-начисление, 1-перерасчет)
	private Integer operTp;
	// включить распределение?
	private Boolean isDist;
	// перерасчет
	private Chng chng;
	private Config config;
	
	// статус записи объема
	private Integer statusVol;
	
	// даты текущего периода (могут быть зависимы от перерасчета)
	Date curDt1;
	Date curDt2;

	// конструктор
	public RequestConfig(Config config) {
		this.config = config;
	}
	
	public Integer getOperTp() {
		return operTp;
	}

	public void setOperTp(Integer operTp) {
		if (operTp==0) {
			//начисление
			// установить текущие даты периода
	    	setCurDt1(config.getCurDt1());
	    	setCurDt2(config.getCurDt2());
			
			// установить статус записи объема
			setStatusVol(0);
		} else if (operTp==1) {
			// установить параметры перерасчета
			// установить текущие даты, для перерасчета
	    	setCurDt1(chng.getDt1());
	    	setCurDt2(chng.getDt2());

	    	// установить статус записи объема
			setStatusVol(1);
		}
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
	
	public void setCurDt1(Date curDt1) {
		this.curDt1 = curDt1;
	}

	public Date getCurDt1() {
		return curDt1;
	}
	
	public void setCurDt2(Date curDt2) {
		this.curDt2 = curDt2;
	}

	public Date getCurDt2() {
		return curDt2;
	}

	public Integer getStatusVol() {
		return statusVol;
	}

	public void setStatusVol(Integer statusVol) {
		this.statusVol = statusVol;
	}

}
