package com.ric.soap_base.SoapThrower;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

import ru.gosuslugi.dom.schema.integration.organizations_registry_common.ExportOrgRegistryRequest;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common.ExportOrgRegistryRequest.SearchCriteria;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common.ExportOrgRegistryResult;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common.ExportOrgRegistryResultType;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common_service.Fault;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common_service.RegOrgPortsType;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common_service.RegOrgService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Started" );
		try {
			checkSoap();
		} catch (Fault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println( "Ended" );
        
    }
    
    public static void checkSoap() throws Fault {
    	
    	RegOrgService service = new RegOrgService();
    	RegOrgPortsType port = service.getRegOrgPort();
    		
    	BindingProvider bindingProvider = (BindingProvider) port;
    	bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, 
    			"http://127.0.0.1:8085/ext-bus-org-registry-common-service/services/OrgRegistryCommon");
    	bindingProvider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, 
    			"lanit");
    	bindingProvider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, 
    			"tv,n8!Ya");
    		
    	ExportOrgRegistryRequest req = new ExportOrgRegistryRequest();  
    	
    	SearchCriteria criteria = new SearchCriteria();
    	criteria.setOGRN("123321");
    	req.getSearchCriteria().add(criteria);

    	ExportOrgRegistryResult res = port.exportOrgRegistry(req);
    		
    	for(ExportOrgRegistryResultType r : res.getOrgData()) {
    		System.out.println(r.getOrgVersion() + ", " + r.getOrgRootEntityGUID());
    	}    	
    	
    }
}
