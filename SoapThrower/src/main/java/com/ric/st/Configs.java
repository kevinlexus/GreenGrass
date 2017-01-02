package com.ric.st;

import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;

public interface Configs {

	public int getEnv();
	public boolean getUseSign();
	public String getOrgPPGuid();
	public String getSrvTestHost();
	public boolean isSrvTest();
	public String getFingerPrint();
	public String getBscLogin();
	public String getBscPass();
	public void setXmlLog();
	public void setUp();
	
}
