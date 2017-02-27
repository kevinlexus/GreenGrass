package com.ric.bill.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.extern.slf4j.Slf4j;

/**
 * DTO - Платежные документы в элементах форм Web-интерфейса
 * @author lev
 *
 */
@Slf4j
public class PayordDTO {

	// Id
	private Integer id;
	// Наименование
	private String name;
	// Fk на тип периода
	private Integer periodTpFk;
	// Выбранные дни
	private String selDays;
	// Пользователь
	private String username;
	// Дата создания
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/Krasnoyarsk")
	private Date dtf;
	

	// конструктор
	public PayordDTO(Integer id, String name, Integer periodTpFk,
			String selDays, String username, Date dtf) {
		super();
		this.id = id;
		this.name = name;
		this.periodTpFk = periodTpFk;
		this.selDays = selDays;
		this.username = username;
		this.dtf = dtf;
	}

	// Здесь важен default конструктор (иначе не примет обратно данные, методом POST)
	public PayordDTO() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
