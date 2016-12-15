package com.ric.st.builder;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.ws.BindingProvider;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import ru.gosuslugi.dom.schema.integration.nsi_base.NsiElementBooleanFieldType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiElementFieldType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiElementNsiFieldType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiElementNsiRefFieldType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiElementStringFieldType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiElementType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiItemInfoType;
import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiItemRequest;
import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiItemResult;
import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiListRequest;
import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiListResult;
import ru.gosuslugi.dom.schema.integration.nsi_common_service.Fault;
import ru.gosuslugi.dom.schema.integration.nsi_common_service.NsiPortsType;
import ru.gosuslugi.dom.schema.integration.nsi_common_service.NsiService;

import com.ric.bill.Utl;
import com.ric.st.NsiBindingBuilders;
import com.ric.st.SoapPreps;
import com.ric.st.excp.CantSendSoap;
import com.ric.st.excp.CantSignSoap;
import com.ric.st.hotora.model.exs.Ulist;
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

	private ExportNsiListRequest req;
	private ExportNsiListResult resList;
	private ExportNsiItemResult resItem;
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
			sp.createRh(false);
		} catch (DatatypeConfigurationException e1) {
			e1.printStackTrace();
			throw new CantSendSoap("Ошибка при подготовке заголовка SOAP запроса!");
		}

		sp.setSignXML(true);
		
		req = new ExportNsiListRequest();
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
	   			true);
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
	   	ExportNsiItemRequest req = new ExportNsiItemRequest();
	    req.setListGroup(grp);
	    req.setRegistryNumber(id);
		req.setId("foo");
		req.setVersion(req.getVersion());
	    
		// создать и подготовить заголовок
		try {
			sp.createRh(true);
		} catch (DatatypeConfigurationException e1) {
			e1.printStackTrace();
			throw new CantSendSoap("Ошибка при подготовке заголовка SOAP запроса!");
		}

	   	port.exportNsiItem(req);
	   	// отправка SOAP, анмаршаллинг результата
	   	resItem = (ExportNsiItemResult) sp.sendSOAP(  
	   			req, 
	   			"exportNsiItem", 			 		
	   			new ExportNsiItemResult(),
	   			config,
	   			true);
	   return resItem;
	}
}
