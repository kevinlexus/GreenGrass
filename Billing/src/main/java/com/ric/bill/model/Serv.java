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

	
	@Column(name = "CD", updatable = false, nullable = false)
    private String cd;// CD 

	@Column(name = "NAME", updatable = false, nullable = true)
    private String name;// наименование 
	
	@Column(name = "FK_MET", updatable = false, nullable = true)
	private Integer met;// fk на услугу содержащую счетчик 

	//вернуть klsk объекта (в каждом подклассе свой метод из за того что колонка может иметь другое название!)
	@Column(name = "FK_K_LSK", nullable = true)
	public Integer getKlsk() {
		return this.klsk;
	}

	public void setKlsk(Integer klsk) {
		this.klsk=klsk;
	}

	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMet() {
		return met;
	}

	public void setMet(Integer met) {
		this.met = met;
	}

}

