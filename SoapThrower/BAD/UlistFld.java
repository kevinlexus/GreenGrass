package com.ric.st.hotora.model.exs;

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

import org.hibernate.annotations.Type;

/**
 * Поля элемента справочника
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "U_LIST_FLD", schema="EXS")
public class UlistFld implements java.io.Serializable  {

	public UlistFld() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EXS")
	@SequenceGenerator(name="SEQ_EXS", sequenceName="EXS.SEQ_U_LIST_FLD", allocationSize=1)	
    @Column(name = "id", unique=true, updatable = false, nullable = false)
	private Integer id;

	// Наименование
	@Column(name = "NAME", updatable = true, nullable = true)
	private String name;
	
	// Значение типа ST
	@Column(name = "S1", updatable = true, nullable = true)
	private String s1;

	// Значение типа NM
	@Column(name = "D1", updatable = true, nullable = true)
	private Date n1;

	// Значение типа DT
	@Column(name = "D1", updatable = true, nullable = true)
	private Date d1;

	// Значение типа BL
	@Type(type= "org.hibernate.type.NumericBooleanType")
	@Column(name = "B1", updatable = true, nullable = true)
	private Boolean b1;

	// Значение типа RF (code), OK (code)
	@Column(name = "REF_CODE", updatable = true, nullable = true)
	private String refCode;

	// Тип значения [(NM)number;  (ST)string;  (DT)date;  (BL) boolean (RF) reference (OK) OkeiRefFieldType]
	@Column(name = "TP", updatable = false, nullable = true)
	private String tp;

	// Значение типа "ссылка на Элемент"
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="REF_GUID", referencedColumnName="GUID")
	private Ulist ulistRef; 

	// Элемент
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="FK_GUID", referencedColumnName="GUID")
	private Ulist ulist; 
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getS1() {
		return s1;
	}

	public void setS1(String s1) {
		this.s1 = s1;
	}

	public Date getN1() {
		return n1;
	}

	public void setN1(Date n1) {
		this.n1 = n1;
	}

	public Date getD1() {
		return d1;
	}

	public void setD1(Date d1) {
		this.d1 = d1;
	}

	public Boolean getB1() {
		return b1;
	}

	public void setB1(Boolean b1) {
		this.b1 = b1;
	}

	public String getRefCode() {
		return refCode;
	}

	public void setRefCode(String refCode) {
		this.refCode = refCode;
	}

	public String getTp() {
		return tp;
	}

	public void setTp(String tp) {
		this.tp = tp;
	}

	public Ulist getUlistRef() {
		return ulistRef;
	}

	public void setUlistRef(Ulist ulistRef) {
		this.ulistRef = ulistRef;
	}

	public Ulist getUlist() {
		return ulist;
	}

	public void setUlist(Ulist ulist) {
		this.ulist = ulist;
	}

	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || !(o instanceof UlistFld))
	        return false;

	    UlistFld other = (UlistFld)o;

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

