package com.ric.st;

import com.ric.st.prep.HouseManagementPreps;

public interface Throwers {

	public void importContractData() throws Exception;
    public void importHouse(HouseManagementPreps hm) throws Exception;
    public void importHouseUpd(HouseManagementPreps hm) throws Exception;
    public void exportAccountData() throws Exception;
}
