package com.ric.st.prep.impl;

import com.ric.st.prep.HouseManagementPreps;


public class HouseManagementPrep implements HouseManagementPreps{

	// GUID дома
	private String houseGuid;
	// HFPAR: ГИС ЖКХ.Площадь, U_LIST:  house_params:Статус культ.насл
	private Double totalSquare;
	// HFPAR: ГИС ЖКХ.Дата постройки, U_LIST: house_params:Год постройки
	private Integer usedYear;
	// HFPAR: ГИС ЖКХ.Статус культурного наследия, U_LIST: house_params:Статус культ.насл
	private Boolean cultHerit;
	// HFPAR: 113ГС-ЭПМД-1.1-17.3.-Этажность дома, U_LIST: house_params:Кол-во этажей
	private String floorCount;
	// HFPAR: ГИС ЖКХ.ОКТМО, U_LIST: ?????? Узнать!
	private String oktmo;
	// HFPAR: ГИС ЖКХ.Состояние, U_LIST: house_params: Состояние
	private String state;
	// HFPAR: ГИС ЖКХ.Количество подземных этажей, U_LIST: house_params: Кол-во подземных этажей
	private String underFloorCount;
	// HFPAR: ГИС ЖКХ.Ключ связи с ГКН/ЕГРП отсутствует, U_LIST: ?????? Узнать!
	private Boolean NoRSOGKNEGRP;
	// HFPAR: 113ГС-ЭПМД-1.1-17.6.-Количество этажей, наименьшее, U_LIST: ?????? Узнать! 
	private Integer minFloorCount;
	
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
	public String getUnderFloorCount() {
		return underFloorCount;
	}
	public void setUnderFloorCount(String underFloorCount) {
		this.underFloorCount = underFloorCount;
	}
	public Boolean getNoRSOGKNEGRP() {
		return NoRSOGKNEGRP;
	}
	public void setNoRSOGKNEGRP(Boolean noRSOGKNEGRP) {
		NoRSOGKNEGRP = noRSOGKNEGRP;
	}
	public Integer getMinFloorCount() {
		return minFloorCount;
	}
	public void setMinFloorCount(Integer minFloorCount) {
		this.minFloorCount = minFloorCount;
	}

	
}
