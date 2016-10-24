package com.ric.hotora.model.fkv;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ric.hotora.model.scott.Kart;


/**
 * LskGuid
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "LSK_GUID", schema="FKV")
public class LskGuid implements java.io.Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "lsk", updatable = false, nullable = true)
	private String lsk;
    
    @Column(name = "ulsk", updatable = false, nullable = true)
	private String ulsk;
    
    @Column(name = "ulsk_Cd", updatable = false, nullable = true)
	private String ulskCd;
    
    @Column(name = "uflat_Cd", updatable = false, nullable = true)
	private String uflatCd;
    
    @Column(name = "reu", updatable = false, nullable = true)
	private String reu;
    
    @Column(name = "kul", updatable = false, nullable = true)
	private String kul;
    
    @Column(name = "nd", updatable = false, nullable = true)
	private String nd;
    
    @Column(name = "kw", updatable = false, nullable = true)
	private String kw;
    
    @Column(name = "gkn", updatable = false, nullable = true)
	private String gkn;
	
	public String getLsk() {
		return this.lsk;
	}

	public void setLsk(String lsk) {
		this.lsk = lsk;
	}

	public String getUlsk() {
		return this.ulsk;
	}

	public void setUlsk(String ulsk) {
		this.ulsk = ulsk;
	}

	public String getUlskCd() {
		return this.ulskCd;
	}

	public void setUlskCd(String ulskCd) {
		this.ulskCd = ulskCd;
	}

	public String getUflatCd() {
		return this.uflatCd;
	}

	public void setUflatCd(String uflatCd) {
		this.uflatCd = uflatCd;
	}

	public String getReu() {
		return this.reu;
	}

	public void setReu(String reu) {
		this.reu = reu;
	}

	public String getKul() {
		return this.kul;
	}

	public void setKul(String kul) {
		this.kul = kul;
	}

	public String getNd() {
		return this.nd;
	}

	public void setNd(String nd) {
		this.nd = nd;
	}

	public String getKw() {
		return this.kw;
	}

	public void setKw(String kw) {
		this.kw = kw;
	}

	public String getGkn() {
		return this.gkn;
	}

	public void setGkn(String gkn) {
		this.gkn = gkn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || !(o instanceof Kart))
	        return false;

	    LskGuid other = (LskGuid)o;

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
