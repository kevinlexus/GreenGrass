package com.ric.bill.model.tr;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ric.bill.Simple;

/**
 * Свойство для "тарифа по свойствам"
 * 
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "PROP", schema="TR")
public class Prop implements java.io.Serializable, Simple {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
	private int id; //id

    @Column(name = "CD", updatable = false, nullable = false)
	private String cd; //cd 

    @Column(name = "NAME", updatable = false, nullable = false)
	private String name; //Наименование 

    @Column(name = "NPP", updatable = false, nullable = true)
	private String npp; //Номер п.п.

    public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
    public String getCd() {
		return this.cd;
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

	public String getNpp() {
		return npp;
	}
	public void setNpp(String npp) {
		this.npp = npp;
	}
}

