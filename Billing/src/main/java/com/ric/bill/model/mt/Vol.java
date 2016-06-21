package com.ric.bill.model.mt;


import java.util.Date;

import javax.persistence.CascadeType;
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
import com.ric.bill.model.bs.Lst;

/**
 * Объемы счетчика 
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "KMP_METER_VOL", schema="MT")
public class Vol implements java.io.Serializable, Simple {

	public Vol (){
		
	}

	public Vol (MeterLog ml, Lst tp, Double vol1, Double vol2, Date date, Date date2){
		setMLog(ml);
		setTp(tp);
		setVol1(vol1);
		setVol2(vol2);
		setDt1(date);
		setDt2(date2);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
	@SequenceGenerator(name="SEQ", sequenceName="MT.KMP_METER_VOL_ID", allocationSize=10) //если сделать allocationSize>1 то появляется javax.persistence.EntityExistsException	
    @Column(name = "ID", unique=true, updatable = false, nullable = false)								//пока сделал 100тыс, тормозить стало меньше
	private Integer id; //id
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_TP", referencedColumnName="ID")
	private Lst tp; 

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_METER_LOG", referencedColumnName="ID")
	private MeterLog mLog; 

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_METER", referencedColumnName="ID")
	private Meter met; 

	@Column(name = "VOL1", updatable = true, nullable = true)
	private Double vol1; 

    @Column(name = "VOL2", updatable = true, nullable = true)
	private Double vol2; 

    //даты начала и окончания произведенного объема
    @Column(name = "DT1", updatable = false, nullable = true)
	private Date dt1;

    @Column(name = "DT2", updatable = false, nullable = true)
	private Date dt2;

    public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
	public Double getVol1() {
		return vol1;
	}
	
	public void setVol1(Double vol1) {
		this.vol1 = vol1;
	}
	public Double getVol2() {
		return vol2;
	}
	public void setVol2(Double vol2) {
		this.vol2 = vol2;
	}

	public MLogs getMLog() {
		return mLog;
	}

	public void setMLog(MeterLog ml) {
		this.mLog = ml;
	}

	public Meter getMet() {
		return met;
	}

	public void setMet(Meter met) {
		this.met = met;
	}


	
}

