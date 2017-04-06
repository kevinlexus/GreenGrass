package com.ric.bill.model.mt.cp;


import java.util.ArrayList;
import java.util.List;
import java.util.List;

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

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;

import com.ric.bill.Storable;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.bs.Base;
import com.ric.bill.model.bs.Par;
import com.ric.bill.model.fn.Chng;
import com.ric.bill.model.mt.main.MeterExs;
import com.ric.bill.model.mt.main.MeterLog;
import com.ric.bill.model.mt.main.Vol;


/**
 * Копия для перерасчетов - Физический счетчик
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "METER_CP", schema="MT")
public class MeterCP extends Base implements java.io.Serializable, Storable {

	public MeterCP (){
		
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_METER_LOG", referencedColumnName="ID")
	private MeterLog meterLog ; 
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="FK_METER", referencedColumnName="ID")
	@BatchSize(size = 50)
	private List<Vol> vol = new ArrayList<Vol>(0);

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_METER", referencedColumnName="ID")
	@BatchSize(size = 50)
	private List<MeterExs> exs = new ArrayList<MeterExs>(0);

	@Column(name = "TRANS_RATIO", updatable = true, nullable = true)
	private Double trRatio; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_CHNG", referencedColumnName="ID")
	private Chng chng; 

	public MeterLog getMeterLog() {
		return meterLog;
	}

	public void setMeterLog(MeterLog meterLog) {
		this.meterLog = meterLog;
	}

	public List<Vol> getVol() {
		return vol;
	}

	public void setVol(List<Vol> vol) {
		this.vol = vol;
	}

	public List<MeterExs> getExs() {
		return exs;
	}

	public void setExs(List<MeterExs> exs) {
		this.exs = exs;
	}
	
	public Double getTrRatio() {
		return trRatio;
	}

	public void setTrRatio(Double trRatio) {
		this.trRatio = trRatio;
	}

	public Chng getChng() {
		return chng;
	}

	public void setChng(Chng chng) {
		this.chng = chng;
	}
	
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || !(o instanceof MeterCP))
	        return false;

	    MeterCP other = (MeterCP)o;

	    if (id == other.getId()) return true;
	    if (id == null) return false;

	    // equivalence by id
	    return id.equals(other.getId());
	}

	public int hashCode() {
	    if (id != null) {
	        return id.hashCode();
	    } else {
	        return super.hashCode();
	    }
	}
	
}

