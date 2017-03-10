package com.ric.bill.model.fn;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ric.bill.Simple;

/**
 * Группа платежного поручения
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "PAYORD_GRP", schema="FN")
public class PayordGrp implements java.io.Serializable, Simple {


	public PayordGrp() {
		
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
	private Integer id;

	// Наименование
	@Column(name = "NAME")
	private String name;

	// Пользователь
	@Column(name = "USERNAME")
	private String username;
	
	// Дата создания
	@Column(name = "DTF")
	private Date dtf;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getDtf() {
		return dtf;
	}

	public void setDtf(Date dtf) {
		this.dtf = dtf;
	}

	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || !(o instanceof PayordGrp))
	        return false;

	    PayordGrp other = (PayordGrp)o;

	    if (getId() == other.getId()) return true;
	    if (getId() == null) return false;

	    // equivalence by id
	    return getId().equals(other.getId());
	}

	public int hashCode() {
	    if (getId() != null) {
	        return getId().hashCode();
	    } else {
	        return super.hashCode();
	    }
	}
	
}

