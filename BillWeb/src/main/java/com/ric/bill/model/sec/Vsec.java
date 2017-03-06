package com.ric.bill.model.sec;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import com.ric.bill.Simple;

/**
 * Представление с правами пользователей
 * 
 *
 */
@SuppressWarnings("serial")
@Entity
@Immutable
@Table(name = "V_SEC", schema="SEC")
public class Vsec implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
    @Column(name = "USER_CD")
	private String userCd; // CD пользователя 

    @Column(name = "KLSK")
	private Integer klsk; // Klsk объекта
    
    @Column(name = "ROLECD")
	private String roleCd; // CD роли 
    
    @Column(name = "ACTCD")
	private String actCd; // CD действия 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserCd() {
		return userCd;
	}

	public void setUserCd(String userCd) {
		this.userCd = userCd;
	}

	public Integer getKlsk() {
		return klsk;
	}

	public void setKlsk(Integer klsk) {
		this.klsk = klsk;
	}

	public String getRoleCd() {
		return roleCd;
	}

	public void setRoleCd(String roleCd) {
		this.roleCd = roleCd;
	}

	public String getActCd() {
		return actCd;
	}

	public void setActCd(String actCd) {
		this.actCd = actCd;
	}

    
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || !(o instanceof Vsec))
	        return false;

	    Vsec other = (Vsec)o;

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

