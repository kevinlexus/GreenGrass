package com.ric.st;

import java.math.BigInteger;

import com.ric.st.prep.HouseManagementPreps;

import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiItemResult;
import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiListResult;

public interface NsiBindingBuilders {

	public ExportNsiListResult getNsiList(String tp) throws Exception;
	public ExportNsiItemResult getNsiItem(String TypeList,BigInteger TypeItem) throws Exception;
	
}
