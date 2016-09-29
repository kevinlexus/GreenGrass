package com.ric.bill.model.mt;


import java.util.ArrayList;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.ParamDef;

import com.ric.bill.Storable;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.bs.Base;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.bs.Par;
import com.ric.bill.model.bs.Serv;


/**
 * Логический счетчик
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "METER_LOG", schema="MT")
public class MeterLog extends Base implements java.io.Serializable, MLogs {

	public MeterLog (){
		
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
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_METER_LOG", referencedColumnName="ID")
	@BatchSize(size = 50)
	private List<Meter> meter = new ArrayList<Meter>(0);

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="FK_METER_LOG", referencedColumnName="ID", updatable = false) //внимание! если здесь убрать updatable = false то будет update kmp_meter_vol fk_meter_log!
	@BatchSize(size = 50)
	private List<Vol> vol = new ArrayList<Vol>(0);

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="NOD_SRC", referencedColumnName="ID")
	@BatchSize(size = 50)
	private List<MeterLogGraph> outside = new ArrayList<MeterLogGraph>(0);

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="NOD_DST", referencedColumnName="ID")
	@BatchSize(size = 50)
	private List<MeterLogGraph> inside = new ArrayList<MeterLogGraph>(0);
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_TP", referencedColumnName="ID")
	private Lst tp; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_SERV", referencedColumnName="ID")
	private Serv serv; 

	/*	УБРАЛ связи с kart, house, так как Hibernate пытается их запрашивать каждый раз, даже если они не нужны,
	 *  (так как нет foreign key сразу на MeterLog, а только через klsk) - НЕ УБИРАТЬ КОММЕНТ! - НЕ ВЗЛЕТЕЛО! (Вернул обратно, описано в MeterLogMngImpl)
	 * 
	 *
	 * 
	 * */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_KLSK_OBJ", referencedColumnName="FK_KLSK_OBJ", updatable = false, insertable = false)
	private Kart kart; 

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_KLSK_OBJ", referencedColumnName="FK_K_LSK", updatable = false, insertable = false)
	private House house; 

	//klsk объекта, к которому принадлежит данный счетчик
    @Column(name = "FK_KLSK_OBJ", updatable = false, nullable = true)
	private Integer klskObj;

	//наименование счетчика, комментарий
    @Column(name = "NAME", updatable = false, nullable = true)
	private String name;
    
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

	public List<Meter> getMeter() {
		return meter;
	}

	public void setMeter(List<Meter> meter) {
		this.meter = meter;
	}

	public Lst getTp() {
		return tp;
	}

	public void setTp(Lst tp) {
		this.tp = tp;
	}

	public List<Vol> getVol() {
		return vol;
	}

	public void setVol(List<Vol> vol) {
		this.vol = vol;
	}

	public Serv getServ() {
		return serv;
	}

	public void setServ(Serv serv) {
		this.serv = serv;
	}

	public Kart getKart() {
		return kart;
	}

	public void setKart(Kart kart) {
		this.kart = kart;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public List<MeterLogGraph> getInside() {
		return inside;
	}

	public void setInside(List<MeterLogGraph> inside) {
		this.inside = inside;
	}

	public List<MeterLogGraph> getOutside() {
		return outside;
	}

	public void setOutside(List<MeterLogGraph> outside) {
		this.outside = outside;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((house == null) ? 0 : house.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((inside == null) ? 0 : inside.hashCode());
		result = prime * result + ((kart == null) ? 0 : kart.hashCode());
		result = prime * result + ((getKlsk() == null) ? 0 : getKlsk().hashCode());
		result = prime * result + ((klskObj == null) ? 0 : klskObj.hashCode());
		result = prime * result + ((meter == null) ? 0 : meter.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((outside == null) ? 0 : outside.hashCode());
		result = prime * result + ((serv == null) ? 0 : serv.hashCode());
		result = prime * result + ((tp == null) ? 0 : tp.hashCode());
		result = prime * result + ((vol == null) ? 0 : vol.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MeterLog other = (MeterLog) obj;
		if (house == null) {
			if (other.house != null)
				return false;
		} else if (!house.equals(other.house))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inside == null) {
			if (other.inside != null)
				return false;
		} else if (!inside.equals(other.inside))
			return false;
		if (kart == null) {
			if (other.kart != null)
				return false;
		} else if (!kart.equals(other.kart))
			return false;
		if (getKlsk() == null) {
			if (other.getKlsk() != null)
				return false;
		} else if (!getKlsk().equals(other.getKlsk()))
			return false;
		if (klskObj == null) {
			if (other.klskObj != null)
				return false;
		} else if (!klskObj.equals(other.klskObj))
			return false;
		if (meter == null) {
			if (other.meter != null)
				return false;
		} else if (!meter.equals(other.meter))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (outside == null) {
			if (other.outside != null)
				return false;
		} else if (!outside.equals(other.outside))
			return false;
		if (serv == null) {
			if (other.serv != null)
				return false;
		} else if (!serv.equals(other.serv))
			return false;
		if (tp == null) {
			if (other.tp != null)
				return false;
		} else if (!tp.equals(other.tp))
			return false;
		if (vol == null) {
			if (other.vol != null)
				return false;
		} else if (!vol.equals(other.vol))
			return false;
		return true;
	}

	
}

