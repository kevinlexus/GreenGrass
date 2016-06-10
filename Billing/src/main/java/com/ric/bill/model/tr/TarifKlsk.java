package com.ric.bill.model.tr;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

import com.ric.bill.Simple;


/**
 * Тариф по объекту
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "TARIFXKLSK", schema="TR")
public class TarifKlsk implements java.io.Serializable, Simple {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
	private Integer id; //id

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_TARIF", referencedColumnName="FK_TARIF")
	private Set<TarifServ> tarserv = new HashSet<TarifServ>(0);

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="FK_TARIF", referencedColumnName="FK_TARIF")
	private Set<TarifServOrg> tarorg = new HashSet<TarifServOrg>(0);
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_TARIF", referencedColumnName="FK_TARIF")
	private Set<TarifServProp> tarprop = new HashSet<TarifServProp>(0);

    @Column(name = "FK_TARIF", updatable = false, nullable = false)
	private Integer fktarif;

    public Integer getId() {
		return this.id;
	}
    
	public void setId(Integer id) {
		this.id = id;
	}

	public Set<TarifServ> getTarserv() {
		return tarserv;
	}

	public void setTarserv(Set<TarifServ> tarserv) {
		this.tarserv = tarserv;
	}

	public Set<TarifServOrg> getTarorg() {
		return tarorg;
	}

	public void setTarorg(Set<TarifServOrg> tarorg) {
		this.tarorg = tarorg;
	}

	public Set<TarifServProp> getTarprop() {
		return tarprop;
	}

	public void setTarprop(Set<TarifServProp> tarprop) {
		this.tarprop = tarprop;
	}

	public Integer getFktarif() {
		return fktarif;
	}

	public void setFktarif(Integer fktarif) {
		this.fktarif = fktarif;
	}
	
}

