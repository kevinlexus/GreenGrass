package com.ric.st.mm;

import java.math.BigInteger;

import ru.gosuslugi.dom.schema.integration.nsi_base.NsiElementType;
import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiItemResult;
import ru.gosuslugi.dom.schema.integration.nsi_common_service.Fault;

import com.ric.st.excp.CantGetNSI;
import com.ric.st.excp.CantSendSoap;
import com.ric.st.excp.CantSignSoap;
import com.ric.st.excp.CantUpdNSI;

public interface UlistMng {

	public ExportNsiItemResult getNsi(String grp, BigInteger id) throws CantGetNSI;
	public NsiElementType getNsiElem(ExportNsiItemResult res, String name, String value);	
	public void refreshNsi(String grp) throws CantUpdNSI;
}
