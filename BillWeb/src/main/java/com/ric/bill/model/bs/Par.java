package com.ric.bill.model.bs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ric.bill.Simple;
import com.ric.bill.model.ps.Pers;

/**
 * Параметр
 * 
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "U_HFPAR", schema="ORALV")
public class Par implements java.io.Serializable, Simple {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
	private int id; //id

    @Column(name = "CD", updatable = false, nullable = false)
	private String cd; //cd 

    @Column(name = "NAME", updatable = false, nullable = false)
	private String name; //Наименование 

    @Column(name = "VAL_TP", updatable = false, nullable = true)
	private String tp; //тип параметра (NM, ST)

    @Column(name = "DATA_TP", updatable = false, nullable = true)
	private String dataTp; //тип данного (SI, LI, ID, BL)
    
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
	
	public String getTp() {
		return tp;
	}
	public void setTp(String tp) {
		this.tp = tp;
	}
	
	public String getDataTp() {
		return dataTp;
	}
	public void setDataTp(String dataTp) {
		this.dataTp = dataTp;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cd == null) ? 0 : cd.hashCode());
		result = prime * result + ((dataTp == null) ? 0 : dataTp.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((tp == null) ? 0 : tp.hashCode());
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
		Par other = (Par) obj;
		if (cd == null) {
			if (other.cd != null)
				return false;
		} else if (!cd.equals(other.cd))
			return false;
		if (dataTp == null) {
			if (other.dataTp != null)
				return false;
		} else if (!dataTp.equals(other.dataTp))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (tp == null) {
			if (other.tp != null)
				return false;
		} else if (!tp.equals(other.tp))
			return false;
		return true;
	}

	
}

