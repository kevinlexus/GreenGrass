package com.ric.bill.model.fn;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ric.bill.model.ar.Kart;

/**
 * Результат начисления
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "KMP_CHRG", schema="FN")
public class Chrg implements java.io.Serializable {

	public Chrg (){
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CHRG")
	@SequenceGenerator(name="SEQ_CHRG", sequenceName="FN.KMP_CHRG_ID", allocationSize=10)	
    @Column(name = "ID", unique=true, updatable = false, nullable = false)			
	private Integer id;
	
    //даты начала и окончания произведенного начисления
    @Column(name = "DT1", updatable = false, nullable = true)
    private Date dt1;

    @Column(name = "DT2", updatable = false, nullable = true)
    private Date dt2;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="LSK", referencedColumnName="LSK", updatable = false)
	private Kart kart;

	//Статус, 0 - архивная запись, 1-текущее начисление, 2 - подготовка к архиву
	@Column(name = "status", nullable = true)
	private Integer status;

	@Column(name = "LSK", updatable = false, insertable = false)
	private String lsk;

	@Column(name = "PERIOD")
	private String period;

	public Kart getKart() {
		return kart;
	}

	public void setKart(Kart kart) {
		this.kart = kart;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getLsk() {
		return lsk;
	}

	public void setLsk(String lsk) {
		this.lsk = lsk;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	
}

