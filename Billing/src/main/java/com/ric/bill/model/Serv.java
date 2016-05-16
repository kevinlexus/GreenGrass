package com.ric.bill.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



/**
 * Класс Услуги
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SERV", schema="TR")
@AttributeOverride(name = "klsk", column = @Column(name = "FK_K_LSK"))
public class Serv extends Base implements java.io.Serializable, Storable {

	// наименование
	private String name; 
	// CD
	private String cd; 

	//вернуть klsk объекта (в каждом подклассе свой метод из за того что колонка может иметь другое название!)
	@Column(name = "FK_K_LSK", nullable = true)
	public Integer getKlsk() {
		return this.klsk;
	}

	public void setKlsk(Integer klsk) {
		this.klsk=klsk;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	
}

