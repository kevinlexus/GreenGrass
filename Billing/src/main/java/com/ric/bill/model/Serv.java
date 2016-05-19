package com.ric.bill.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ric.bill.Storable;



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

	@Column(name = "FK_ODN", updatable = false, nullable = true)
	private Integer odn;// fk на услугу содержащую счетчик ОДН 

	@Column(name = "NPP", updatable = false, nullable = true)
	private Integer npp;// № п.п.
	
	@Column(name = "NPP2", updatable = false, nullable = true)
	private Integer npp2;// № п.п. для распределения объема

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

	public Integer getOdn() {
		return odn;
	}

	public void setOdn(Integer odn) {
		this.odn = odn;
	}

	public Integer getNpp() {
		return npp;
	}

	public void setNpp(Integer npp) {
		this.npp = npp;
	}

	public Integer getNpp2() {
		return npp2;
	}

	public void setNpp2(Integer npp2) {
		this.npp2 = npp2;
	}

}

