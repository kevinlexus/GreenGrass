package com.ric.bill.model.bs;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ric.bill.Simple;

/**
 * Элемент списка
 * 
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "LIST", schema="BS")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region="billCache")
@Cacheable
public class Lst implements java.io.Serializable, Simple {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
	private Integer id; //id

	@Column(name = "CD", updatable = false, nullable = false)
	private String cd; //cd 

    @Column(name = "NAME", updatable = false, nullable = false)
	private String name; //Наименование 

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_LISTTP", referencedColumnName="ID")
	private LstTp lstTp ; 

	
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
	public LstTp getLstTp() {
		return lstTp;
	}
	public void setLstTp(LstTp lstTp) {
		this.lstTp = lstTp;
	}

}

