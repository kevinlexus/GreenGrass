package com.ric.st;

import com.ric.st.prep.HouseManagementPreps;

public interface PrepImportHouses {

	public void setHm(HouseManagementPreps hm);
	public HouseManagementPreps getHm();
	public void importHouseUpd() throws Exception;	
}
