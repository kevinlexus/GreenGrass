package com.direct.webflow;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

//простой класс строки из справочника spr_gen_itm
//описывающего шаги выполнения формирования

@Entity
@Table(name = "SPR_GEN_ITM")
public class SprGenItm {

	private int id;
	private String cd;
	private String name;
	private Integer npp;
	private Double proc;
	private Boolean sel;

	
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "CD", nullable = false)
	public String getCd() {
		return cd;
	}
	public void setCd(String cd) {
		this.cd = cd;
	}

	@Column(name = "NAME", nullable = true)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "NPP", nullable = true)
	public int getNpp() {
		return npp;
	}
	public void setNpp(int npp) {
		this.npp = npp;
	}

	@Column(name = "PROC", nullable = true)
	public Double getProc() {
		return proc;
	}
	public void setProc(Double proc) {
		this.proc = proc;
	}

/*	@Column(name = "SEL", nullable = true)
	public Integer getSel() {
		return sel;
	}
	public void setSel(Integer sel) {
		this.sel = sel;
	}*/
	@Type(type= "org.hibernate.type.NumericBooleanType")
	@Column(name = "SEL", nullable = true)
	public Boolean getSel() {
		return sel;
	}
	
	public void setSel(Boolean sel) {
		this.sel = sel;
	}
}