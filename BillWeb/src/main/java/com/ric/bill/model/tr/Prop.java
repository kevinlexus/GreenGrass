package com.ric.bill.model.tr;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ric.bill.Simple;
import com.ric.bill.model.bs.Par;

/**
 * Свойство для "тарифа по свойствам"
 * 
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "PROP", schema="TR")
public class Prop implements java.io.Serializable, Simple {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
	private int id; //id

    @Column(name = "CD", updatable = false, nullable = false)
	private String cd; //cd 

    @Column(name = "NAME", updatable = false, nullable = false)
	private String name; //Наименование 

    @Column(name = "NPP", updatable = false, nullable = true)
	private String npp; //Номер п.п.

    public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
    public String getCd() {
		return this.cd;
	}
	public void setCd(String cd) {
		this.cd = cd;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getNpp() {
		return npp;
	}
	public void setNpp(String npp) {
		this.npp = npp;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cd == null) ? 0 : cd.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((npp == null) ? 0 : npp.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prop other = (Prop) obj;
		if (cd == null) {
			if (other.cd != null)
				return false;
		} else if (!cd.equals(other.cd))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (npp == null) {
			if (other.npp != null)
				return false;
		} else if (!npp.equals(other.npp))
			return false;
		return true;
	}
	
	
}

