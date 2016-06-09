package com.ric.bill.model.mt;


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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ric.bill.Simple;
import com.ric.bill.model.bs.Lst;


/**
 * Связи счетчика
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "METER_LOG_GRAPH", schema="MT")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="billCache")
public class MeterLogGraph implements java.io.Serializable, Simple {

	public MeterLogGraph (){
		
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
	private int id; //id

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_TP", referencedColumnName="ID")
	private Lst tp; 

	//Узел - источник
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="NOD_SRC", referencedColumnName="ID")
	private MeterLog src; 

	//Узел - назначение
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="NOD_DST", referencedColumnName="ID")
	private MeterLog dst; 

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

    public MeterLog getSrc() {
		return src;
	}

	public BigDecimal getPrc() {
		return prc;
	}
	
	public void setPrc(BigDecimal prc) {
		this.prc = prc;
	}

	public void setSrc(MeterLog src) {
		this.src = src;
	}

	public void setDst(MeterLog dst) {
		this.dst = dst;
	}

	public MeterLog getDst() {
		return dst;
	}

}

