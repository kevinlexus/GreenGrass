package com.ric.hotora.model.scott;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Лицевой счет 
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "KART", schema="SCOTT")
public class Kart implements java.io.Serializable  {

	public Kart() {
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lsk", updatable = false, nullable = false)
	private String lsk;
	
    @Column(name = "reu", updatable = false, nullable = false)
	private String reu; 
	
    @Column(name = "kul", updatable = false, nullable = false)
	private String kul; 

    @Column(name = "nd", updatable = false, nullable = false)
	private String nd; 

    @Column(name = "fio", updatable = false, nullable = false)
	private String fio; 
    
    public String getLsk() {
		return lsk;
	}

	public void setLsk(String lsk) {
		this.lsk = lsk;
	}
	
	public String getReu() {
		return reu;
	}

	public void setReu(String reu) {
		this.reu = reu;
	}

	public String getKul() {
		return kul;
	}

	public void setKul(String kul) {
		this.kul = kul;
	}

	public String getNd() {
		return nd;
	}

	public void setNd(String nd) {
		this.nd = nd;
	}

	public String getFio() {
		return fio;
	}

	public void setFio(String fio) {
		this.fio = fio;
	}


	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || !(o instanceof Kart))
	        return false;

	    Kart other = (Kart)o;

	    if (getLsk() == other.getLsk()) return true;
	    if (getLsk() == null) return false;

	    // equivalence by id
	    return getLsk().equals(other.getLsk());
	}

	public int hashCode() {
	    if (getLsk() != null) {
	        return getLsk().hashCode();
	    } else {
	        return super.hashCode();
	    }
	}
	
}

