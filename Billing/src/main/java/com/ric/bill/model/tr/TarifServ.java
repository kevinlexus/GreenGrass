package com.ric.bill.model.tr;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ric.bill.Simple;

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
	
	
}

