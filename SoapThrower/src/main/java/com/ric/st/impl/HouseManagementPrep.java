package com.ric.st.impl;

import ru.gosuslugi.dom.schema.integration.base.OKTMORefType;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest;
import ru.gosuslugi.dom.schema.integration.house_management.ApartmentHouseUOType.BasicCharacteristicts;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.ApartmentHouseToCreate;

public class HouseManagementPrep {

	private ApartmentHouse ah;
	private ApartmentHouseToCreate ac;
	private BasicCharacteristicts bc;
	private OKTMORefType oktmo;
	private ImportHouseUORequest req;
	
	HouseManagementPrep(){
		setAh(new ApartmentHouse());
    	setAc(new ApartmentHouseToCreate());
    	setBc(new BasicCharacteristicts());
    	setOktmo(new OKTMORefType());
    	setReq(new ImportHouseUORequest());
		
	}

	public ApartmentHouse getAh() {
		return ah;
	}

	public void setAh(ApartmentHouse ah) {
		this.ah = ah;
	}

	public ApartmentHouseToCreate getAc() {
		return ac;
	}

	public void setAc(ApartmentHouseToCreate ac) {
		this.ac = ac;
	}

	public BasicCharacteristicts getBc() {
		return bc;
	}

	public void setBc(BasicCharacteristicts bc) {
		this.bc = bc;
	}

	public OKTMORefType getOktmo() {
		return oktmo;
	}

	public void setOktmo(OKTMORefType oktmo) {
		this.oktmo = oktmo;
	}

	public ImportHouseUORequest getReq() {
		return req;
	}

	public void setReq(ImportHouseUORequest req) {
		this.req = req;
	}
	
}
