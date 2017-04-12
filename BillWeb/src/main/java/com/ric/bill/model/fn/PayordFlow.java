package com.ric.bill.model.fn;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ric.bill.Simple;
import com.ric.bill.model.bs.Org;
import com.ric.bill.model.tr.Serv;

/**
 * Движение по платежке
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "PAYORD_FLOW", schema="FN")
public class PayordFlow implements java.io.Serializable, Simple {


	public PayordFlow() {
		
	}

	public PayordFlow(Payord payord, Serv serv, Org uk, Double summa, Date dt) {
		super();
		this.payord = payord;
		this.serv = serv;
		this.uk = uk;
		this.summa = summa;
		this.dt = dt;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PAYORD_FLOW")
	@SequenceGenerator(name="SEQ_PAYORD_FLOW", sequenceName="FN.SEQ_PAYORD_FLOW", allocationSize=1) 	
    @Column(name = "ID", unique=true, updatable = false, nullable = false)					
	private Integer id;

	// Платежка
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_PAYORD", referencedColumnName="ID")
	private Payord payord; 
	
	// Услуга
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_SERV", referencedColumnName="ID")
	private Serv serv; 

	// УК
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_UK", referencedColumnName="ID")
	private Org uk; 
	
	// Сумма
	@Column(name = "SUMMA")
	private Double summa;

    //дата операции
    @Column(name = "DT", updatable = false, nullable = true)
    private Date dt;
	
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Payord getPayord() {
		return payord;
	}

	public void setPayord(Payord payord) {
		this.payord = payord;
	}

	public Serv getServ() {
		return serv;
	}

	public void setServ(Serv serv) {
		this.serv = serv;
	}

	public Org getUk() {
		return uk;
	}

	public void setUk(Org uk) {
		this.uk = uk;
	}

	public Double getSumma() {
		return summa;
	}

	public void setSumma(Double summa) {
		this.summa = summa;
	}

	public Date getDt() {
		return dt;
	}

	public void setDt(Date dt) {
		this.dt = dt;
	}

	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || !(o instanceof PayordFlow))
	        return false;

	    PayordFlow other = (PayordFlow)o;

	    if (getId() == other.getId()) return true;
	    if (getId() == null) return false;

	    // equivalence by id
	    return getId().equals(other.getId());
	}

	public int hashCode() {
	    if (getId() != null) {
	        return getId().hashCode();
	    } else {
	        return super.hashCode();
	    }
	}
	
}

