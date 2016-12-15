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
 * Справочник элементов
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "U_LIST", schema="EXS")
public class Ulist implements java.io.Serializable  {

	public Ulist() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EXS")
	@SequenceGenerator(name="SEQ_EXS", sequenceName="EXS.SEQ_U_LIST", allocationSize=1)	
    @Column(name = "id", unique=true, updatable = false, nullable = false)
	private Integer id;

	public Ulist(String cd, String name, String s1, Date dt1, Date dt2,
			Boolean actual, UlistTp ulistTp) {
		super();
		this.cd = cd;
		this.name = name;
		this.s1 = s1;
		this.dt1 = dt1;
		this.dt2 = dt2;
		this.actual = actual;
		this.ulistTp = ulistTp;
	}

	// CD элемента
	@Column(name = "CD", updatable = true, nullable = true)
	private String cd;
	
	// Наименование элемента
	@Column(name = "NAME", updatable = true, nullable = true)
	private String name;
	
	// ИЗ ГИС ЖКХ: GUID элемента
	@Column(name = "S1", updatable = true, nullable = true)
	private String s1;

	// ИЗ ГИС ЖКХ: Дата начала действия значения
	@Column(name = "DT1", updatable = true, nullable = true)
	private Date dt1;

	// ИЗ ГИС ЖКХ: Дата окончания действия значения
	@Column(name = "DT2", updatable = true, nullable = true)
	private Date dt2;
	
	// ИЗ ГИС ЖКХ: Признак актуальности элемента справочника
	@Type(type= "org.hibernate.type.NumericBooleanType")
	@Column(name = "ACTUAL", nullable = true)
	private Boolean actual;

	// Тип справочника
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="FK_LISTTP", referencedColumnName="ID")
	private UlistTp ulistTp; 

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UlistTp getUlistTp() {
		return ulistTp;
	}

	public void setUlistTp(UlistTp ulistTp) {
		this.ulistTp = ulistTp;
	}

	public String getS1() {
		return s1;
	}

	public void setS1(String s1) {
		this.s1 = s1;
	}

	public Date getDt1() {
		return dt1;
	}

	public void setDt1(Date dt1) {
		this.dt1 = dt1;
	}

	public Date getDt2() {
		return dt2;
	}

	public void setDt2(Date dt2) {
		this.dt2 = dt2;
	}

	public Boolean getActual() {
		return actual;
	}

	public void setActual(Boolean actual) {
		this.actual = actual;
	}

	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || !(o instanceof Ulist))
	        return false;

	    Ulist other = (Ulist)o;

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

