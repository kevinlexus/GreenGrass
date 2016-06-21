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

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;

import com.ric.bill.Storable;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.bs.Base;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.bs.Serv;


/**
 * Логический счетчик
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "METER_LOG", schema="MT")
@AttributeOverride(name = "klsk", column = @Column(name = "FK_K_LSK"))
@FilterDefs({
    @FilterDef(name = "FILTER_GEN_DT", defaultCondition = ":DT1 BETWEEN DT1 AND DT2", 
    		parameters = {@ParamDef(name = "DT1", type = "date")
    		}
    ), 
    //фильтр, когда даты внутри диапазона (для объемов по счетчикам)
    @FilterDef(name = "FILTER_GEN_DT_INNER", defaultCondition = "DT1 BETWEEN :DT1 AND :DT2 AND DT2 BETWEEN :DT1 AND :DT2", 
	parameters = {@ParamDef(name = "DT1", type = "date"),
    			  @ParamDef(name = "DT2", type = "date")
	}
)   
})
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
	private Set<Meter> meter = new HashSet<Meter>(0);

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="FK_METER_LOG", referencedColumnName="ID")
	@Filters({
	    @Filter(name = "FILTER_GEN_DT_INNER")})
	@BatchSize(size = 50)
	private Set<Vol> vol = new HashSet<Vol>(0);

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="NOD_SRC", referencedColumnName="ID")
	@Filters({
	    @Filter(name = "FILTER_GEN_DT")})
	@BatchSize(size = 50)
	private Set<MeterLogGraph> outside = new HashSet<MeterLogGraph>(0);

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="NOD_DST", referencedColumnName="ID")
	@Filters({
	    @Filter(name = "FILTER_GEN_DT")})
	@BatchSize(size = 50)
	private Set<MeterLogGraph> inside = new HashSet<MeterLogGraph>(0);
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_TP", referencedColumnName="ID")
	private Lst tp; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_SERV", referencedColumnName="ID")
	private Serv serv; 

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_KLSK_OBJ", referencedColumnName="FK_K_LSK", updatable = false, insertable = false)
	private Kart kart; 

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_KLSK_OBJ", referencedColumnName="FK_K_LSK", updatable = false, insertable = false)
	private House house; 

	//klsk объекта, к которому принадлежит данный счетчик --нужен ли, если есть на прямую объекты kart, house?
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

	public Set<MeterLogGraph> getInside() {
		return inside;
	}

	public void setInside(Set<MeterLogGraph> inside) {
		this.inside = inside;
	}

	public Set<MeterLogGraph> getOutside() {
		return outside;
	}

	public void setOutside(Set<MeterLogGraph> outside) {
		this.outside = outside;
	}

	
}

