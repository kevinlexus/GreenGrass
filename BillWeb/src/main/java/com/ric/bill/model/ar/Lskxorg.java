package com.ric.bill.model.ar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Организация
 * 
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "KMP_LSKXORG", schema="FN")
public class Lskxorg implements java.io.Serializable {

	@Id
    @Column(name = "ID", unique = true, updatable = false, nullable = false)
	private Integer id; //id

	@Column(name = "LSK", updatable = false, insertable = false)
	private String lsk;
	

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
	
	
}

