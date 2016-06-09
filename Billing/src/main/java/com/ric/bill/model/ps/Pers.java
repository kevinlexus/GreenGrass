package com.ric.bill.model.ps;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ric.bill.Simple;

/**
 * Персона
 * 
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "PERS", schema="PS")
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="billCache")
public class Pers implements java.io.Serializable, Simple {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
	private int id; //id

    @Column(name = "NM_LAST", updatable = false, nullable = true)
	private String lastname; //Фамилия 

    @Column(name = "NM_FIRST", updatable = false, nullable = true)
	private String firstname; //Имя 
    
    @Column(name = "NM_PATR", updatable = false, nullable = true)
	private String middlename; //Отчество 

    public Integer getId() {
		return this.id;
	}
    
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getMiddlename() {
		return middlename;
	}
	
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

}

