package com.ric.bill.model.tr;

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
import com.ric.bill.model.bs.Serv;

/**
 * Услуги по тарифу
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "TARIF_SERV", schema="TR")
public class TarifServ implements java.io.Serializable, Simple {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
	private Integer id; //id

    @Column(name = "FK_TARIF", updatable = false, nullable = false)
	private Integer fkTarif;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_SERV", referencedColumnName="ID")
	private Serv serv; 

    public Integer getId() {
		return this.id;
	}
    
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFkTarif() {
		return fkTarif;
	}

	public void setFkTarif(Integer fkTarif) {
		this.fkTarif = fkTarif;
	}
	
	public Serv getServ() {
		return serv;
	}

	public void setServ(Serv serv) {
		this.serv = serv;
	}

	
}

