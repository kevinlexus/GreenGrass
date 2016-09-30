package com.ric.bill.model.ar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ric.bill.MeterContains;
import com.ric.bill.Storable;
import com.ric.bill.model.bs.Base;

/**
 * Улица
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "STREET", schema="AR")
public class Street extends Base implements java.io.Serializable {

	public Street() {
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
	protected Integer id; //id записи

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_STREET", referencedColumnName="ID")
	private List<House> house = new ArrayList<House>(0);

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_AREA", referencedColumnName="ID", updatable = false)
	private Area area;

	//наименование улицы
	@Column(name = "NAME", nullable = true)
	private String name; 
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<House> getHouse() {
		return house;
	}

	public void setHouse(List<House> house) {
		this.house = house;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Street)) 
			return false;
		Street other = (Street) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}


	
}
