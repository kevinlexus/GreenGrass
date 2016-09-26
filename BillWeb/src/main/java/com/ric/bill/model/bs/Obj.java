package com.ric.bill.model.bs;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ric.bill.Storable;

/**
 * Объект
 * 
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "OBJ", schema="BS")
@AttributeOverride(name = "klsk", column = @Column(name = "FK_K_LSK"))
public class Obj extends Base implements java.io.Serializable, Storable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
	private int id; //id

    @Column(name = "CD", updatable = false, nullable = false)
	private String cd; //cd 

    @Column(name = "NAME", updatable = false, nullable = false)
	private String name; //Наименование 

	//вернуть klsk объекта (в каждом подклассе свой метод из за того что колонка может иметь другое название!)
	@Column(name = "FK_K_LSK", nullable = true)
	private Integer klsk;

	public Integer getKlsk() {
		return this.klsk;
	}
	
	public void setKlsk(Integer klsk) {
		this.klsk=klsk;
	}
    
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
       if (!(o instanceof Obj)) return false;
     
       Obj otherObj = (Obj) o;
     
       if (getId() != null ?
           !getId().equals(otherObj.getId()) : otherObj.getId() != null)
           return false;
     
       return true;
   }
	
}

