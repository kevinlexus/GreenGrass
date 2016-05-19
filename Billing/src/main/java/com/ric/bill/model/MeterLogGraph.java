package com.ric.bill.model;


import java.math.BigDecimal;

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
 * Связи счетчика
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "METER_LOG_GRAPH", schema="MT")
public class MeterLogGraph implements java.io.Serializable, Simple {

	public MeterLogGraph (){
		
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
	private int id; // id

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_TP", referencedColumnName="ID")
	private Lst tp; 

	@Column(name = "NOD_SRC", updatable = false, nullable = true)
	private Integer nodsrc; // Узел - источник

    @Column(name = "NOD_DST", updatable = false, nullable = true)
	private Integer noddst; // Узел - назначение

    @Column(name = "PERCENT", updatable = false, nullable = true)
	private BigDecimal prc; 

    public Integer getId() {
		return this.id;
	}
	
    public void setId(Integer id) {
		this.id = id;
	}

	public Lst getTp() {
		return tp;
	}

	public void setTp(Lst tp) {
		this.tp = tp;
	}

    public Integer getNodsrc() {
		return nodsrc;
	}

	public void setNodsrc(Integer nodsrc) {
		this.nodsrc = nodsrc;
	}

	public Integer getNoddst() {
		return noddst;
	}

	public void setNoddst(Integer noddst) {
		this.noddst = noddst;
	}

	public BigDecimal getPrc() {
		return prc;
	}
	
	public void setPrc(BigDecimal prc) {
		this.prc = prc;
	}

}

