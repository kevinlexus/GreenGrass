package com.ric.bill;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "METER", schema="MT")
public class Meter {

	private int id;
	private Integer fKlsk, fMLog;
	
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "FK_K_LSK", unique = false, nullable = true)
	public Integer getfKlsk() {
		return fKlsk;
	}
	
	public void setfKlsk(Integer fKlsk) {
		this.fKlsk = fKlsk;
	}

	@Column(name = "FK_K_LSK", unique = false, nullable = true)
	public Integer getfMLog() {
		return fMLog;
	}

	public void setfMLog(Integer fMLog) {
		this.fMLog = fMLog;
	}
	
	
	
}

