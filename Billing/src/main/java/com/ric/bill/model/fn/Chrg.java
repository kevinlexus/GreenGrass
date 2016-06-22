package com.ric.bill.model.fn;


import java.util.Date;

import javax.persistence.CascadeType;
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

import com.ric.bill.Simple;
import com.ric.bill.model.bs.Lst;

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
	@SequenceGenerator(name="SEQ_CHRG", sequenceName="FN.SEQ_CHRG", allocationSize=10000)	
    @Column(name = "ID", unique=true, updatable = false, nullable = false)			
	private Integer id;
	
	
}

