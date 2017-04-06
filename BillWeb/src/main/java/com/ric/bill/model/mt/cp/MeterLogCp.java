package com.ric.bill.model.mt.cp;


import java.util.ArrayList;
import java.util.List;

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
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.ric.bill.model.ar.House;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.bs.Base;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.fn.Chng;
import com.ric.bill.model.mt.main.MLogs;
import com.ric.bill.model.mt.main.Meter;
import com.ric.bill.model.mt.main.MeterLogGraph;
import com.ric.bill.model.mt.main.Vol;
import com.ric.bill.model.tr.Serv;


/**
 * Копия для перерасчета - Логический счетчик
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "METER_LOG_CP", schema="MT")
public class MeterLogCp extends Base implements java.io.Serializable, MLogs<VolCp> {

	public MeterLogCp (){
		
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
	//@Fetch(FetchMode.SUBSELECT) // убрал subselect, так как внезапно начало тормозить  
	private List<Meter> meter = new ArrayList<Meter>(0);

	/* TODO
	 * Иногда (!!) происходит увеличение в десятки раз записей Vol, в случае использования совместно EAGER и @BatchSize(size = 50)
	 * Именно иногда, повторить проблему сложно!
	 * 
	 * ВНИМАНИЕ! НЕ ИСПОЛЬЗОВАТЬ EAGER СОВМЕСТНО С @BatchSize
	 * ВНИМАНИЕ! НЕ ИСПОЛЬЗОВАТЬ EAGER СОВМЕСТНО С @BatchSize  РАЗОБРАТЬСЯ С ПРОБЛЕМОЙ!!!
	 * ВНИМАНИЕ! НЕ ИСПОЛЬЗОВАТЬ EAGER СОВМЕСТНО С @BatchSize
	 * ВНИМАНИЕ! НЕ ИСПОЛЬЗОВАТЬ EAGER СОВМЕСТНО С @BatchSize
	 * 
	 */
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="FK_METER_LOG", referencedColumnName="ID", updatable = false) //внимание! если здесь убрать updatable = false то будет update kmp_meter_vol fk_meter_log!
	//@BatchSize(size = 50)
	@Fetch(FetchMode.SUBSELECT) // убрал subselect, так как внезапно начало тормозить  
	private List<VolCp> vol = new ArrayList<VolCp>(0);

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="NOD_SRC", referencedColumnName="ID")
	//@BatchSize(size = 50)
	@Fetch(FetchMode.SUBSELECT) // убрал subselect, так как внезапно начало тормозить
	private List<MeterLogGraph> outside = new ArrayList<MeterLogGraph>(0);

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="NOD_DST", referencedColumnName="ID")
	//@BatchSize(size = 50)
	@Fetch(FetchMode.SUBSELECT) // убрал subselect, так как внезапно начало тормозить
	private List<MeterLogGraph> inside = new ArrayList<MeterLogGraph>(0);
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_TP", referencedColumnName="ID")
	private Lst tp; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_SERV", referencedColumnName="ID")
	private Serv serv; 

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_KLSK_OBJ", referencedColumnName="FK_KLSK_OBJ", updatable = false, insertable = false)
	private Kart kart; 

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_KLSK_OBJ", referencedColumnName="FK_K_LSK", updatable = false, insertable = false)
	private House house; 

	//klsk объекта, к которому принадлежит данный счетчик
    @Column(name = "FK_KLSK_OBJ", updatable = false, nullable = true)
	private Integer klskObj;

	// № ввода
    @Column(name = "ENTRY", updatable = false, nullable = true)
	private String entry;
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_CHNG", referencedColumnName="ID")
	private Chng chng; 
	
	public Integer getKlskObj() {
		return klskObj;
	}

	public void setKlskObj(Integer klskObj) {
		this.klskObj=klskObj;
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

	public List<VolCp> getVol() {
		return vol;
	}

	public void setVol(List<VolCp> vol) {
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

	public String getEntry() {
		return entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	
	public Chng getChng() {
		return chng;
	}
	
	public void setChng(Chng chng) {
		this.chng = chng;
	}
	
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || !(o instanceof MeterLogCp))
	        return false;

	    MeterLogCp other = (MeterLogCp)o;

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

