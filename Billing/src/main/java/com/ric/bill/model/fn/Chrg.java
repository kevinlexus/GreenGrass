package com.ric.bill.model.fn;


import java.math.BigDecimal;
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
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.bs.Org;
import com.ric.bill.model.bs.Serv;

/**
 * Результат начисления
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "KMP_CHRG", schema="FN")
public class Chrg implements java.io.Serializable, Simple {


	public Chrg() {
		
	}
			
	public Chrg(Kart kart, Serv serv, Org org, int status, String period,
			BigDecimal sumFull, BigDecimal sumAmnt, BigDecimal vol,
			BigDecimal price, Lst tp, Date dt1, Date dt2) {
		
		setKart(kart);
		setOrg(org);
		setServ(serv);
		setStatus(status);
		setPeriod(period);
		setSumFull(sumFull.doubleValue());
		setSumAmnt(sumAmnt.doubleValue());
		setVol(vol.doubleValue());
		setPrice(price.doubleValue());
		setTp(tp);
		setDt1(dt1);
		setDt2(dt2);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CHRG")
	@SequenceGenerator(name="SEQ_CHRG", sequenceName="FN.KMP_CHRG_ID", allocationSize=10)	
    @Column(name = "ID", unique=true, updatable = false, nullable = false)			
	private Integer id;
	
    //даты начала и окончания произведенного начисления
    @Column(name = "DT1", updatable = false, nullable = true)
    private Date dt1;

    @Column(name = "DT2", updatable = false, nullable = true)
    private Date dt2;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="LSK", referencedColumnName="LSK", updatable = false)
	private Kart kart;

	//Статус, 0 - архивная запись, 1-текущее начисление, 2 - подготовка к архиву
	@Column(name = "status", nullable = true)
	private Integer status;

	@Column(name = "LSK", updatable = false, insertable = false)
	private String lsk;

	@Column(name = "PERIOD")
	private String period;

	@Column(name = "SUM_FULL")
	private Double sumFull;
	
	@Column(name = "SUM_AMNT")
	private Double sumAmnt;

	@Column(name = "VOL")
	private Double vol;
	
	@Column(name = "PRICE")
	private Double price;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_CHRG_TP", referencedColumnName="ID")
	private Lst tp; 

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_SERV", referencedColumnName="ID")
	private Serv serv; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_ORG", referencedColumnName="ID")
	private Org org; 

    public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Kart getKart() {
		return kart;
	}

	public void setKart(Kart kart) {
		this.kart = kart;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getLsk() {
		return lsk;
	}

	public void setLsk(String lsk) {
		this.lsk = lsk;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public Double getSumFull() {
		return sumFull;
	}

	public void setSumFull(Double sumFull) {
		this.sumFull = sumFull;
	}

	public Double getSumAmnt() {
		return sumAmnt;
	}

	public void setSumAmnt(Double sumAmnt) {
		this.sumAmnt = sumAmnt;
	}

	public Double getVol() {
		return vol;
	}

	public void setVol(Double vol) {
		this.vol = vol;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getDt1() {
		return dt1;
	}

	public void setDt1(Date dt1) {
		this.dt1 = dt1;
	}

	public Date getDt2() {
		return dt2;
	}

	public void setDt2(Date dt2) {
		this.dt2 = dt2;
	}

	public Lst getTp() {
		return tp;
	}

	public void setTp(Lst tp) {
		this.tp = tp;
	}

	public Serv getServ() {
		return serv;
	}

	public void setServ(Serv serv) {
		this.serv = serv;
	}

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

	
}

