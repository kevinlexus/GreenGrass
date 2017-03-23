package com.ric.bill.model.fn;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ric.bill.Simple;
import com.ric.bill.model.ar.Area;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.bs.Org;
import com.ric.bill.model.tr.Serv;

/**
 * Компонент формулы платежного поручения
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "PAYORD_CMP", schema="FN")
public class PayordCmp implements java.io.Serializable, Simple {


	public PayordCmp() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PAYORD_CMP")
	@SequenceGenerator(name="SEQ_PAYORD_CMP", sequenceName="FN.SEQ_PAYORD_CMP", allocationSize=1) 	
    @Column(name = "ID", unique=true, updatable = false, nullable = false)					
	private Integer id;

	// Пользователь
	@Column(name = "USERNAME", insertable = false, updatable = false)
	private String username;
	
	// Дата создания
	@Column(name = "DTF", insertable = false, updatable = false)
	private Date dtf;
	
	// Платежка
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_PAYORD", referencedColumnName="ID")
	private Payord payord; 
	
	// Вариант сбора информации (например начисление по оборотной ведомости)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_VAR", referencedColumnName="ID")
	private Lst var; 

	// Услуга
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_SERV", referencedColumnName="ID")
	private Serv serv; 

	// Организация
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_ORG", referencedColumnName="ID")
	private Org org; 
	
	// Объект (область действия) Город, дом, УК
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_AREA", referencedColumnName="ID")
	private Area area; 

	// Маркер
	@Column(name = "MARK")
	private String mark;
	
	// Сумма
	@Column(name = "SUMMA")
	private Double summa;

	
	public Lst getVar() {
		return var;
	}

	public void setVar(Lst var) {
		this.var = var;
	}

	public Serv getServ() {
		return serv;
	}

	public void setServ(Serv serv) {
		this.serv = serv;
	}

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Payord getPayord() {
		return payord;
	}

	public void setPayord(Payord payord) {
		this.payord = payord;
	}

	public Double getSumma() {
		return summa;
	}

	public void setSumma(Double summa) {
		this.summa = summa;
	}

	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || !(o instanceof PayordCmp))
	        return false;

	    PayordCmp other = (PayordCmp)o;

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

