package com.ric.bill.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ric.bill.Simple;

/**
 * Реестр Регистрационных Действий(РегД)
 * 
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "REG", schema="PS")
public class RegState implements java.io.Serializable, Simple {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
	private int id; // id

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="LSK", referencedColumnName="LSK", updatable = false)
	private Kart kart;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_PERS", referencedColumnName="ID", updatable = false)
	private Pers pers;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_TEMP_TP", referencedColumnName="ID", updatable = false)
	private Lst tempTp;

    @Column(name = "DT_REG", updatable = false, nullable = true)
	private int dtReg; // Дата регистрации
	
    @Column(name = "DT_REG_TS", updatable = false, nullable = true)
	private int dtRegTs; // Дата регистрации, фактически установлена

    @Column(name = "DT_UNREG", updatable = false, nullable = true)
	private int dtUnReg; // Дата снятия с учёта

    @Column(name = "DT_UNREG_TS", updatable = false, nullable = true)
	private int dtUnRegTs; // Дата снятия с учёта, фактически установлена

	public Integer getId() {
		return this.id;
	}
    
	public void setId(Integer id) {
		this.id = id;
	}

	public Pers getPers() {
		return pers;
	}

	public void setPers(Pers pers) {
		this.pers = pers;
	}

	public Lst getTempTp() {
		return tempTp;
	}

	public void setTempTp(Lst tempTp) {
		this.tempTp = tempTp;
	}

	public int getDtReg() {
		return dtReg;
	}

	public void setDtReg(int dtReg) {
		this.dtReg = dtReg;
	}

	public int getDtRegTs() {
		return dtRegTs;
	}

	public void setDtRegTs(int dtRegTs) {
		this.dtRegTs = dtRegTs;
	}

	public int getDtUnReg() {
		return dtUnReg;
	}

	public void setDtUnReg(int dtUnReg) {
		this.dtUnReg = dtUnReg;
	}

	public int getDtUnRegTs() {
		return dtUnRegTs;
	}

	public void setDtUnRegTs(int dtUnRegTs) {
		this.dtUnRegTs = dtUnRegTs;
	}
	
}

