package com.ric.bill.model.bs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ric.bill.Simple;

/**
 * Организация
 * 
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "ORG", schema="BS")
public class Org implements java.io.Serializable {

	@Id
    @Column(name = "ID", updatable = false, nullable = false)
	private Integer id; //id

	@Column(name = "CD", updatable = false, nullable = false)
	private String cd; //cd 

    @Column(name = "NAME", updatable = false, nullable = false)
	private String name; //Наименование 

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

   @Override
   public boolean equals(Object o) {
       if (this == o) return true;
       if (!(o instanceof Org)) return false;
     
       Org otherOrg = (Org) o;
     
       if (getId() != null ?
           !getId().equals(otherOrg.getId()) : otherOrg.getId() != null)
           return false;
     
       return true;
   }
	
}

