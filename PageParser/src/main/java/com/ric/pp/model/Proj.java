package com.ric.pp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * Запись о проекте во внешней системе
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "PP_PROJ", schema="SCOTT")
public class Proj implements java.io.Serializable {

	public Proj() {
		
	}
	
	public Proj(Integer outerId, Integer tp, String shortTxt, Integer page) {
		super();
		this.setOuterId(outerId);
		this.tp = tp;
		this.shortTxt = shortTxt;
		this.page = page;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PROJ")
	@SequenceGenerator(name="SEQ_PROJ", sequenceName="SCOTT.CHANGES_ID", allocationSize=1) 	
    @Column(name = "ID", updatable = false, nullable = false)
	protected Integer id; //id записи

    //внешний ID проекта 
	@Column(name = "OUTER_ID")
	private Integer outerId;
	
    //Тип внешней системы (0-fl.ru) 
	@Column(name = "TP")
	private Integer tp;

	//краткое описание проекта
	@Lob
	@Column(name = "SHORT_TXT", nullable = true)
	private String shortTxt; 
	
    //Взято со страницы №
	@Column(name = "PAGE")
	private Integer page;

    //Дата добавления проекта (строка)
	@Column(name = "STRDT1")
	private String strDt1;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getShortTxt() {
		return shortTxt;
	}
	public void setShortTxt(String shortTxt) {
		this.shortTxt = shortTxt;
	}
	public Integer getTp() {
		return tp;
	}
	public void setTp(Integer tp) {
		this.tp = tp;
	}
	
	public Integer getOuterId() {
		return outerId;
	}
	public void setOuterId(Integer outerId) {
		this.outerId = outerId;
	}
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getStrDt1() {
		return strDt1;
	}

	public void setStrDt1(String strDt1) {
		this.strDt1 = strDt1;
	}

	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || !(o instanceof Proj))
	        return false;

	    Proj other = (Proj)o;

	    if (id == other.getId()) return true;
	    if (id == null) return false;

	    // equivalence by id
	    return id.equals(other.getId());
	}

	public int hashCode() {
	    if (id != null) {
	        return id.hashCode();
	    } else {
	        return super.hashCode();
	    }
	}

	
}
