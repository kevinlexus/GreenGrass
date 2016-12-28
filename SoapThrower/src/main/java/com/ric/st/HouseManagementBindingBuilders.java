package com.ric.st;

import ru.gosuslugi.dom.schema.integration.house_management.ImportResult;
import ru.gosuslugi.dom.schema.integration.house_management_service.Fault;

import com.ric.st.excp.CantSendSoap;
import com.ric.st.prep.HouseManagementPreps;

public interface HouseManagementBindingBuilders {

	public ImportResult createApartmentHouse() throws CantSendSoap, Fault;
	
}
