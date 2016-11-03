package com.ric.st;

import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;

public interface Configs {

	public NsiRef getTz();
	public String getOrgPPGuid();
	public String getSrvTestHost();
	public boolean isSrvTest();
	public String getBscLogin();
	public String getBscPass();
	public void setXmlLog();
	
}
