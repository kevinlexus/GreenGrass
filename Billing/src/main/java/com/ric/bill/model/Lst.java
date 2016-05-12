package com.ric.bill.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Элемент списка
 * 
 *
 */
@Entity
@Table(name = "LIST", schema="BS")
public class Lst implements java.io.Serializable, Simple {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
	private int id; // id

	@Id
    @Column(name = "FK_TP", updatable = false, nullable = false)
	private int fk_tp; // fk_tp на list_tp

	@Column(name = "CD", updatable = false, nullable = false)
	private String cd; // cd 

    @Column(name = "NAME", updatable = false, nullable = false)
	private String name; // Наименование 

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_LISTTP", referencedColumnName="ID")
	private LstTp lstTp ; 

	
    public int getId() {
		return this.id;
	}
	public void setId(int id) {
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
	public int getFk_tp() {
		return fk_tp;
	}
	public void setFk_tp(int fk_tp) {
		this.fk_tp = fk_tp;
	}
	public LstTp getLstTp() {
		return lstTp;
	}
	public void setLstTp(LstTp lstTp) {
		this.lstTp = lstTp;
	}

}

