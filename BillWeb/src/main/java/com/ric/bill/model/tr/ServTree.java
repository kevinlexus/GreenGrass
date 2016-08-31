package com.ric.bill.model.tr;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ric.bill.Simple;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.bs.Serv;

/**
 * Иерархия услуг
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SERV_TREE", schema="TR")
public class ServTree implements java.io.Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
	private Integer id; //id

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_SERV", referencedColumnName="ID")
	private Serv serv; 

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_TP", referencedColumnName="ID")
	private Lst tp; 

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="PARENT_ID", referencedColumnName="ID")
	private ServTree parent; 
	
	public Integer getId() {
		return this.id;
	}
    
	public void setId(Integer id) {
		this.id = id;
	}

	public Serv getServ() {
		return serv;
	}

	public void setServ(Serv serv) {
		this.serv = serv;
	}

	public Lst getTp() {
		return tp;
	}

	public void setTp(Lst tp) {
		this.tp = tp;
	}

	public ServTree getParent() {
		return parent;
	}

	public void setParent(ServTree parent) {
		this.parent = parent;
	}

	@Override
   public boolean equals(Object o) {
       if (this == o) return true;
       if (!(o instanceof ServTree)) return false;
     
       ServTree otherST = (ServTree) o;
     
       if (getId() != null ?
           !getId().equals(otherST.getId()) : otherST.getId() != null)
           return false;
     
       return true;
   }
	
}

