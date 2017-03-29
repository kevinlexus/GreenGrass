package com.ric.bill.model.oralv;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ric.bill.Simple;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.bs.AddrTp;

/**
 * Справочник всех объектов Klsk Objects - KO
 * 
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "K_LSK", schema="ORALV")
public class Ko implements java.io.Serializable, Simple {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
	private Integer id; //id

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_ADDRTP", referencedColumnName="ID")
	private AddrTp addrTp ; 

	
    public Ko() {
		super();
	}
    
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public AddrTp getAddrTp() {
		return addrTp;
	}
	
	public void setAddrTp(AddrTp addrTp) {
		this.addrTp = addrTp;
	}
	
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || !(o instanceof Ko))
	        return false;

	    Ko other = (Ko)o;

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

