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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.ric.bill.Simple;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.bs.Org;
import com.ric.bill.model.mt.Meter;
import com.ric.bill.model.mt.Vol;
import com.ric.bill.model.tr.Serv;

/**
 * Заголовочная таблица - перерасчеты
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "PAYORD", schema="FN")
public class Payord implements java.io.Serializable, Simple {


	public Payord() {
		
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
	private Integer id;

	// № п.п.
	@Column(name = "NPP")
	private Integer npp;

	// Наименование
	@Column(name = "NAME")
	private String name;

	// Выбранные дни
	@Column(name = "SEL_DAYS")
	private String selDays;

	// Пользователь
	@Column(name = "USERNAME")
	private String username;
	
	// Дата создания
	@Column(name = "DTF")
	private Date dtf;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_PERIODTP", referencedColumnName="ID")
	private Lst periodTp; 

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNpp() {
		return npp;
	}

	public void setNpp(Integer npp) {
		this.npp = npp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Lst getPeriodTp() {
		return periodTp;
	}

	public void setPeriodTp(Lst periodTp) {
		this.periodTp = periodTp;
	}

	public String getSelDays() {
		return selDays;
	}

	public void setSelDays(String selDays) {
		this.selDays = selDays;
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
	    if (o == null || !(o instanceof Payord))
	        return false;

	    Payord other = (Payord)o;

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

