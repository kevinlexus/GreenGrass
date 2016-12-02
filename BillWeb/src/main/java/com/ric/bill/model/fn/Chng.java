package com.ric.bill.model.fn;


import java.util.ArrayList;
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
 * Перерасчет
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
	private List<Vol> vol = new ArrayList<Vol>(0);
	
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

	public List<Vol> getVol() {
		return vol;
	}

	public void setVol(List<Vol> vol) {
		this.vol = vol;
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

