package com.ric.bill.model.mt;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;

import com.ric.bill.Storable;
import com.ric.bill.model.bs.Base;


/**
 * Физический счетчик
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "METER", schema="MT")
@AttributeOverride(name = "klsk", column = @Column(name = "FK_K_LSK"))
@FilterDefs({
    @FilterDef(name = "FILTER_GEN_DT", defaultCondition = ":DT1 BETWEEN DT1 AND DT2", 
    		parameters = {@ParamDef(name = "DT1", type = "date")
    		}
    )
})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="billCache")
public class Meter extends Base implements java.io.Serializable, Storable {

	public Meter (){
		
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
	protected Integer id; //id записи

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	/* даты начала и окончания действия счетчика - используются ли?
    @Column(name = "DT1", updatable = false, nullable = true)
	private Date dt1;

    @Column(name = "DT2", updatable = false, nullable = true)
	private Date dt2;*/
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_METER_LOG", referencedColumnName="ID")
	private MeterLog meterLog ; 
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_METER", referencedColumnName="ID")
	@Filters({
	    @Filter(name = "FILTER_GEN_DT")})
	private Set<Vol> vol = new HashSet<Vol>(0);

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_METER", referencedColumnName="ID")
	@Filters({
	    @Filter(name = "FILTER_GEN_DT")})
	private Set<MeterExs> exs = new HashSet<MeterExs>(0);

	//вернуть klsk объекта (в каждом подклассе свой метод из за того что колонка может иметь другое название!)
    @Column(name = "FK_K_LSK", updatable = false, nullable = false)
	public Integer getKlsk() {
		return klsk;
	}

	public void setKlsk(Integer klsk) {
		this.klsk=klsk;
	}

/*	public Date getDt1() {
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
	}*/

	public MeterLog getMeterLog() {
		return meterLog;
	}

	public void setMeterLog(MeterLog meterLog) {
		this.meterLog = meterLog;
	}

	public Set<Vol> getVol() {
		return vol;
	}

	public void setVol(Set<Vol> vol) {
		this.vol = vol;
	}

	public Set<MeterExs> getExs() {
		return exs;
	}

	public void setExs(Set<MeterExs> exs) {
		this.exs = exs;
	}
	
}

