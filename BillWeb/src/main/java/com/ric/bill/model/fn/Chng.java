package com.ric.bill.model.fn;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.ric.bill.Simple;
import com.ric.bill.model.mt.Meter;
import com.ric.bill.model.mt.Vol;

/**
 * Заголовочная таблица - перерасчеты
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "CHNG", schema="FN")
public class Chng implements java.io.Serializable, Simple {


	public Chng() {
		
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
	private Integer id;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_CHNG", referencedColumnName="ID")
	@Fetch(FetchMode.SUBSELECT)
	private List<Chrg> chrg = new ArrayList<Chrg>(0);

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_CHNG", referencedColumnName="ID")
	@Fetch(FetchMode.SUBSELECT)
	private List<ChngLsk> chngLsk = new ArrayList<ChngLsk>(0);
	
	@Column(name = "PRICE_NEW")
	private Double priceNew;
	
	// период (х.з. какой период, уточнить) TODO
	@Column(name = "PERIOD")
	private String period;

	// документ-основание перерасчета
	@Column(name = "ACT_NAME")
	private String actName;

	// даты начала и окончания произведенного перерасчета
    @Column(name = "DT1", updatable = false, nullable = true)
    private Date dt1;

    @Column(name = "DT2", updatable = false, nullable = true)
    private Date dt2;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public List<Chrg> getChrg() {
		return chrg;
	}

	public void setChrg(List<Chrg> chrg) {
		this.chrg = chrg;
	}

	public Double getPriceNew() {
		return priceNew;
	}

	public void setPriceNew(Double priceNew) {
		this.priceNew = priceNew;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
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

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public List<ChngLsk> getChngLsk() {
		return chngLsk;
	}

	public void setChngLsk(List<ChngLsk> chngLsk) {
		this.chngLsk = chngLsk;
	}

	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || !(o instanceof Chng))
	        return false;

	    Chng other = (Chng)o;

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

