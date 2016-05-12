package com.ric.bill.model;


import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "METER_LOG", schema="MT")
@AttributeOverride(name = "klsk", column = @Column(name = "FK_K_LSK"))
public class MeterLog extends Base implements java.io.Serializable, Storable {

	public MeterLog (){
		
	}
	
	// даты начала и окончания действия счетчика
	private Date dt1;
	private Date dt2;
	//наименование счетчика, комментарий
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="FK_METER_LOG", referencedColumnName="ID")
	private Set<Meter> meter = new HashSet<Meter>(0);

	//вернуть klsk объекта (в каждом подклассе свой метод из за того что колонка может иметь другое название!)
    @Column(name = "FK_K_LSK", updatable = false, nullable = false)
	public Integer getKlsk() {
		return klsk;
	}

	public void setKlsk(Integer klsk) {
		this.klsk=klsk;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Meter> getMeter() {
		return meter;
	}

	public void setMeter(Set<Meter> meter) {
		this.meter = meter;
	}
	
	
	
}

