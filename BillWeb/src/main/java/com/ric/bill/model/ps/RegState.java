package com.ric.bill.model.ps;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.cache.annotation.Cacheable;

import com.ric.bill.Simple;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.bs.Lst;

/**
 * Пасп стол. Временно отсутствующие, временно присутствующие.
 * 
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "REG_STATE", schema="PS")
public class RegState implements java.io.Serializable, Registrable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
	private int id; //id

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="LSK", referencedColumnName="LSK", updatable = false)
	private Kart kart;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_PERS", referencedColumnName="ID", updatable = false)
	private Pers pers;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="FK_TEMP_TP", referencedColumnName="ID", updatable = false)
	private Lst tp;
	
    @Column(name = "DT_REG", updatable = false, nullable = true)
	private Date dtReg; //Дата регистрации
	
    @Column(name = "DT_REG_TS", updatable = false, nullable = true)
	private Date dtRegTs; //Дата регистрации, фактически установлена

    @Column(name = "DT_UNREG", updatable = false, nullable = true)
	private Date dtUnReg; //Дата снятия с учёта

    @Column(name = "DT_UNREG_TS", updatable = false, nullable = true)
	private Date dtUnRegTs; //Дата снятия с учёта, фактически установлена

	@Column(name = "LSK", updatable = false, insertable = false)
	private Integer lsk;

	public Integer getId() {
		return this.id;
	}
    
	public void setId(Integer id) {
		this.id = id;
	}

	public Pers getPers() {
		return pers;
	}

	public void setPers(Pers pers) {
		this.pers = pers;
	}

	public Date getDtReg() {
		return dtReg;
	}

	public void setDtReg(Date dtReg) {
		this.dtReg = dtReg;
	}

	public Date getDtRegTs() {
		return dtRegTs;
	}

	public void setDtRegTs(Date dtRegTs) {
		this.dtRegTs = dtRegTs;
	}

	public Date getDtUnReg() {
		return dtUnReg;
	}

	public void setDtUnReg(Date dtUnReg) {
		this.dtUnReg = dtUnReg;
	}

	public Date getDtUnRegTs() {
		return dtUnRegTs;
	}

	public void setDtUnRegTs(Date dtUnRegTs) {
		this.dtUnRegTs = dtUnRegTs;
	}

	public Lst getTp() {
		return tp;
	}

	public void setTp(Lst tp) {
		this.tp = tp;
	}

	public Integer getLsk() {
		return lsk;
	}

	public void setLsk(Integer lsk) {
		this.lsk = lsk;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dtReg == null) ? 0 : dtReg.hashCode());
		result = prime * result + ((dtRegTs == null) ? 0 : dtRegTs.hashCode());
		result = prime * result + ((dtUnReg == null) ? 0 : dtUnReg.hashCode());
		result = prime * result
				+ ((dtUnRegTs == null) ? 0 : dtUnRegTs.hashCode());
		result = prime * result + id;
		result = prime * result + ((kart == null) ? 0 : kart.hashCode());
		result = prime * result + ((lsk == null) ? 0 : lsk.hashCode());
		result = prime * result + ((pers == null) ? 0 : pers.hashCode());
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
		RegState other = (RegState) obj;
		if (dtReg == null) {
			if (other.dtReg != null)
				return false;
		} else if (!dtReg.equals(other.dtReg))
			return false;
		if (dtRegTs == null) {
			if (other.dtRegTs != null)
				return false;
		} else if (!dtRegTs.equals(other.dtRegTs))
			return false;
		if (dtUnReg == null) {
			if (other.dtUnReg != null)
				return false;
		} else if (!dtUnReg.equals(other.dtUnReg))
			return false;
		if (dtUnRegTs == null) {
			if (other.dtUnRegTs != null)
				return false;
		} else if (!dtUnRegTs.equals(other.dtUnRegTs))
			return false;
		if (id != other.id)
			return false;
		if (kart == null) {
			if (other.kart != null)
				return false;
		} else if (!kart.equals(other.kart))
			return false;
		if (lsk == null) {
			if (other.lsk != null)
				return false;
		} else if (!lsk.equals(other.lsk))
			return false;
		if (pers == null) {
			if (other.pers != null)
				return false;
		} else if (!pers.equals(other.pers))
			return false;
		if (tp == null) {
			if (other.tp != null)
				return false;
		} else if (!tp.equals(other.tp))
			return false;
		return true;
	}
	

	
}

