package com.ric.st.builder;

import java.math.BigInteger;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.ws.BindingProvider;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiItemRequest;
import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiItemResult;
import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiListRequest;
import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiListResult;
import ru.gosuslugi.dom.schema.integration.nsi_common_service.Fault;
import ru.gosuslugi.dom.schema.integration.nsi_common_service.NsiPortsType;
import ru.gosuslugi.dom.schema.integration.nsi_common_service.NsiService;

import com.ric.st.NsiBindingBuilders;
import com.ric.st.SoapPreps;
import com.ric.st.excp.CantSendSoap;
import com.ric.st.excp.CantSignSoap;
import com.ric.st.impl.Config;
import com.sun.xml.ws.developer.WSBindingProvider;

@Service
@Slf4j
public class NsiBindingBuilder implements NsiBindingBuilders {

	@Autowired
	private ApplicationContext ctx;
    @PersistenceContext
    private EntityManager em;
	@Autowired
	private Config config;
	@Autowired
	private SoapPreps sp;

	private ExportNsiListResult resList;
	private ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiItemResult resItem;
	private NsiService service;
	private NsiPortsType port;
	
	@PostConstruct
	public void init() throws Exception {
    	// создать сервис и порт
    	service = new NsiService();
    	port = service.getNsiPort();
    	// подготовительный объект
    	sp.setUp(port, (BindingProvider) port, (WSBindingProvider) port);

    	// подписывать XML?
    	sp.setSignXML(false);

    	// создать и подготовить заголовок запроса
    	//sp.createRh(config.getOrgPPGuid(), true);

    	log.info("Выполнилось init()");
	}


	/**
	 * Получить список справочников
	 * @param grp - вид справочника (NSI, NISRAO)
	 * @throws Fault 
	 * @throws CantSendSoap 
	 * @throws CantSignSoap 
	 * @throws Exception
	 */
	public ExportNsiListResult getNsiList(String grp) throws Fault, CantSignSoap, CantSendSoap { 
		// создать и подготовить заголовок
		try {
			sp.createRh(true);
		} catch (DatatypeConfigurationException e1) {
			e1.printStackTrace();
			throw new CantSendSoap("Ошибка при подготовке заголовка SOAP запроса!");
		}

		// подписывать
		sp.setSignXML(true);
		
		ExportNsiListRequest req = new ExportNsiListRequest();
		req.setListGroup(grp);
		req.setVersion(req.getVersion());
		req.setId("foo");
		req.setVersion(req.getVersion());

		
		port.exportNsiList(req);
	   	// отправить SOAP, анмаршаллинг результата
	    resList = (ExportNsiListResult) sp.sendSOAP(  
	   			req, 
	   			"exportNsiList", 			 		
	   			new ExportNsiListResult(),
	   			config,
	   			true, 0);
	   return resList;
	}
	
	/**
	 * Получить справочник
	 * @param grp - вид справочника (NSI, NISRAO)
	 * @throws Fault 
	 * @throws CantSendSoap 
	 * @throws CantSignSoap 
	 * @throws Exception
	 */
	public ExportNsiItemResult getNsiItem(String grp, BigInteger id) throws Fault, CantSignSoap, CantSendSoap {
		// создать и подготовить заголовок
		try {
			sp.createRh(true);
		} catch (DatatypeConfigurationException e1) {
			e1.printStackTrace();
			throw new CantSendSoap("Ошибка при подготовке заголовка SOAP запроса!");
		}

		// подписывать
		sp.setSignXML(true);

		ExportNsiItemRequest req = new ExportNsiItemRequest();
	    req.setListGroup(grp);
	    req.setRegistryNumber(id);
		req.setId("foo");
		req.setVersion(req.getVersion());
	    
	   	port.exportNsiItem(req);
	   	// отправка SOAP, анмаршаллинг результата
	   	resItem = (ExportNsiItemResult) sp.sendSOAP(  
	   			req, 
	   			"exportNsiItem", 			 		
	   			new ExportNsiItemResult(),
	   			config,
	   			true, 1);
	   	
	   return resItem;
	}
}
