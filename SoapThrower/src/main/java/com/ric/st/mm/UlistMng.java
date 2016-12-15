package com.ric.st.mm;

import ru.gosuslugi.dom.schema.integration.nsi_common_service.Fault;

import com.ric.st.excp.CantSendSoap;
import com.ric.st.excp.CantSignSoap;
import com.ric.st.excp.CantUpdNSI;

public interface UlistMng {

	public void refreshNsi(String grp) throws CantUpdNSI, Fault, CantSignSoap, CantSendSoap;
}
