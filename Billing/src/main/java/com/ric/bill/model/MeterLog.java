package com.ric.bill.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Логический счетчик
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "METER_LOG", schema="MT")
@AttributeOverride(name = "klsk", column = @Column(name = "FK_K_LSK"))
public class MeterLog extends Base implements java.io.Serializable, Storable {

	public MeterLog (){
		
	}
	
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="FK_METER_LOG", referencedColumnName="ID")
	private Set<Meter> meter = new HashSet<Meter>(0);

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="FK_METER_LOG", referencedColumnName="ID")
	private Set<Vol> vol = new HashSet<Vol>(0);

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_TP", referencedColumnName="ID")
	private Lst tp; 
	
	//klsk объекта, к которому принадлежит данный счетчик
    @Column(name = "FK_KLSK_OBJ", updatable = false, nullable = true)
	private Integer klskObj;

	//наименование счетчика, комментарий
    @Column(name = "NAME", updatable = false, nullable = true)
	private String name;
    
    //вернуть klsk объекта (в каждом подклассе свой метод из за того что колонка может иметь другое название!)
    @Column(name = "FK_K_LSK", updatable = false, nullable = false)
    public Integer getKlsk() {
		return klsk;
	}

	public void setKlsk(Integer klsk) {
		this.klsk=klsk;
	}

	public Integer getKlskObj() {
		return klskObj;
	}

	public void setKlskObj(Integer klskObj) {
		this.klskObj=klskObj;
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

	public Lst getTp() {
		return tp;
	}

	public void setTp(Lst tp) {
		this.tp = tp;
	}

	public Set<Vol> getVol() {
		return vol;
	}

	public void setVol(Set<Vol> vol) {
		this.vol = vol;
	}
	
	
}

