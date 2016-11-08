package com.ric.st.impl;

import com.ric.st.HouseManagementPreps;


public class HouseManagementPrep implements HouseManagementPreps{

	private String houseGuid;
	private Double totalSquare;
	private Integer usedYear;
	private Boolean cultHerit;
	private String floorCount;
	private String oktmo;
	private String state;
	
	public String getHouseGuid() {
		return houseGuid;
	}
	public void setHouseGuid(String houseGuid) {
		this.houseGuid = houseGuid;
	}
	public Double getTotalSquare() {
		return totalSquare;
	}
	public void setTotalSquare(Double totalSquare) {
		this.totalSquare = totalSquare;
	}
	public Integer getUsedYear() {
		return usedYear;
	}
	public void setUsedYear(Integer usedYear) {
		this.usedYear = usedYear;
	}
	public Boolean getCultHerit() {
		return cultHerit;
	}
	public void setCultHerit(Boolean cultHerit) {
		this.cultHerit = cultHerit;
	}
	public String getFloorCount() {
		return floorCount;
	}
	public void setFloorCount(String floorCount) {
		this.floorCount = floorCount;
	}
	public String getOktmo() {
		return oktmo;
	}
	public void setOktmo(String oktmo) {
		this.oktmo = oktmo;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	
}
