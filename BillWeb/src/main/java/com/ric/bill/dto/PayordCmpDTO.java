package com.ric.bill.dto;


import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * DTO - Компонент формулы платежного поручения
 * @author lev
 *
 */
public class PayordCmpDTO {


	// Здесь важен default конструктор (иначе не примет обратно данные, методом POST)
	public PayordCmpDTO() {
		
	}

	private Integer id;

	// конструктор
	public PayordCmpDTO(Integer id, String username, Date dtf,
			Integer payordFk, Integer varFk, Integer servFk, Integer orgFk,
			Integer areaFk, String mark, Double summa) {
		super();
		this.id = id;
		this.username = username;
		this.dtf = dtf;
		this.payordFk = payordFk;
		this.varFk = varFk;
		this.servFk = servFk;
		this.orgFk = orgFk;
		this.areaFk = areaFk;
		this.mark = mark;
		this.summa = summa;
	}

	// Пользователь
	private String username;
	
	// Дата создания
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/Krasnoyarsk")
	private Date dtf;
	
	// Платежка
	private Integer payordFk; 
	
	// Вариант сбора информации (например начисление по оборотной ведомости)
	private Integer varFk; 

	// Услуга
	private Integer servFk; 

	// Организация
	private Integer orgFk; 
	
	// Объект (область действия) Город, дом, УК
	private Integer areaFk; 

	// Маркер
	private String mark;

	// Сумма
	private Double summa;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getPayordFk() {
		return payordFk;
	}

	public void setPayordFk(Integer payordFk) {
		this.payordFk = payordFk;
	}

	public Integer getVarFk() {
		return varFk;
	}

	public void setVarFk(Integer varFk) {
		this.varFk = varFk;
	}

	public Integer getServFk() {
		return servFk;
	}

	public void setServFk(Integer servFk) {
		this.servFk = servFk;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public Integer getOrgFk() {
		return orgFk;
	}

	public void setOrgFk(Integer orgFk) {
		this.orgFk = orgFk;
	}

	public Integer getAreaFk() {
		return areaFk;
	}

	public void setAreaFk(Integer areaFk) {
		this.areaFk = areaFk;
	}

	public Double getSumma() {
		return summa;
	}

	public void setSumma(Double summa) {
		this.summa = summa;
	}
	
}
