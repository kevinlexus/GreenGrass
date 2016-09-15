package com.ric.bill.model.ar;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ric.bill.model.bs.Org;

/**
 * Организация
 * 
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "LSKXORG", schema="AR")
public class Lskxorg implements java.io.Serializable {

	@Id
    @Column(name = "ID", updatable = false, nullable = false)
	private Integer id; //id

	@Column(name = "LSK", updatable = false, insertable = false)
	private String lsk;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="LSK", referencedColumnName="LSK", updatable = false)
	private Kart kart;

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getLsk() {
		return lsk;
	}
	public void setLsk(String lsk) {
		this.lsk = lsk;
	}
	public Kart getKart() {
		return kart;
	}
	public void setKart(Kart kart) {
		this.kart = kart;
	}
	
	
}

