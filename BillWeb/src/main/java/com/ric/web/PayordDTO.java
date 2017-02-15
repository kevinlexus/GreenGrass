package com.ric.web;

import java.util.Date;

/**
 * DTO - Платежные документы в элементах форм Web-интерфейса
 * @author lev
 *
 */
public class PayordDTO {

	// Id
	private Integer id;
	// № п.п.
	private Integer npp;
	// Наименование
	private String name;
	// Fk на тип периода
	private Integer periodTpFk;
	// Выбранные дни
	private String selDays;
	// Пользователь
	private String username;
	// Дата создания
	private Date dtf;
	

	// конструктор
	public PayordDTO(Integer id, Integer npp, String name, Integer periodTpFk,
			String selDays, String username, Date dtf) {
		super();
		this.id = id;
		this.npp = npp;
		this.name = name;
		this.periodTpFk = periodTpFk;
		this.selDays = selDays;
		this.username = username;
		this.dtf = dtf;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getNpp() {
		return npp;
	}


	public void setNpp(Integer npp) {
		this.npp = npp;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getPeriodTpFk() {
		return periodTpFk;
	}


	public void setPeriodTpFk(Integer periodTpFk) {
		this.periodTpFk = periodTpFk;
	}


	public String getSelDays() {
		return selDays;
	}


	public void setSelDays(String selDays) {
		this.selDays = selDays;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public Date getDtf() {
		return dtf;
	}


	public void setDtf(Date dtf) {
		this.dtf = dtf;
	}

	
	
}
