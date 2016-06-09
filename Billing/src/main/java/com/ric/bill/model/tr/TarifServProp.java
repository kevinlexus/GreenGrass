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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ric.bill.Simple;
import com.ric.bill.model.bs.Serv;



/**
 * Свойство по услуге по тарифу
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "TARIF_SERV_PROP", schema="TR")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="billCache")
public class TarifServProp implements java.io.Serializable, Simple {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
	private Integer id; //id

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_SERV_PROP", referencedColumnName="ID")
	private Prop prop ; 

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_SERV", referencedColumnName="ID")
	private Serv serv ; 

	@Column(name = "N1", updatable = false, nullable = true)
	private Double n1; //значение n1 

	public Integer getId() {
		return this.id;
	}
    
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Prop getProp() {
		return prop;
	}

	public void setProp(Prop prop) {
		this.prop = prop;
	}

	public Double getN1() {
		return n1;
	}

	public void setN1(Double n1) {
		this.n1 = n1;
	}

	public Serv getServ() {
		return serv;
	}

	public void setServ(Serv serv) {
		this.serv = serv;
	}

	
}

