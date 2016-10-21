package com.ric.soapthrower;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.Future;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ric.finday.model.scott.Kart;

import ru.gosuslugi.dom.schema.integration.organizations_registry_common.ExportOrgRegistryRequest;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common.ExportOrgRegistryResult;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common.ExportOrgRegistryResultType;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common.ExportOrgRegistryRequest.SearchCriteria;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common_service.Fault;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common_service.RegOrgPortsType;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common_service.RegOrgService;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringJUnit4ClassRunner.class) //только для JUnit, можно убрать!
@ContextConfiguration(classes = {AppConfig.class}) //только для JUnit, можно убрать!
@Service
public class ThrowerMng {

	@Autowired
	private ApplicationContext ctx;
    @PersistenceContext
    private EntityManager em;
	
    @Test
    public void checkIt() {
    	
    	Kart kart = em.find(Kart.class, "07234421");
    	if (kart!=null){
	    	System.out.println(kart.getReu());
	    	System.out.println(kart.getKul());
	    	System.out.println(kart.getNd());
	    	System.out.println(kart.getFio());
    	} else {
    		System.out.println("не найден лс!");
    	}

    }
    
	//отправить XML
    public void send () throws DatatypeConfigurationException, Fault {

    	
    	RegOrgService service = new RegOrgService();
    	RegOrgPortsType port = service.getRegOrgPort();
    		
    	BindingProvider bindingProvider = (BindingProvider) port;
    	bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, 
    			"http://127.0.0.1:8085/ext-bus-org-registry-common-service/services/OrgRegistryCommon");
    	
    	//Возможно, отключить basic авторизацию, как подключат сертификат?
    	bindingProvider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "lanit");
    	bindingProvider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "tv,n8!Ya");
    		
    	ExportOrgRegistryRequest req = new ExportOrgRegistryRequest();  
    	
    	SearchCriteria cr = new SearchCriteria();
    	cr.setOGRN("123321");
    	req.getSearchCriteria().add(cr);
    	
    	GregorianCalendar c = new GregorianCalendar();
    	c.setTime(new Date());
    	XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
    	req.setLastEditingDateFrom(date2);

    	ExportOrgRegistryResult res = port.exportOrgRegistry(req);
    		
    	for(ExportOrgRegistryResultType r : res.getOrgData()) {
    		System.out.println(r.getOrgVersion() + ", " + r.getOrgRootEntityGUID());
    	}    	

    	//Запрос - счетчики
    	//ImportMeteringDeviceValuesRequest req2 = new ImportMeteringDeviceValuesRequest();  
    	//req2.getMeteringDevicesValues().add(index, element);
    	
    	
    	
    }
}
