package com.ric.st.builder;

import java.io.IOException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.MessageContext;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.w3._2000._09.xmldsig_.SignatureType;
import org.w3._2000._09.xmldsig_.SignatureValueType;

import ru.gosuslugi.dom.schema.integration.base.RequestHeader;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiElementType;
import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiItemRequest;
import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiItemResult;
import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiListRequest;
import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiListResult;
import ru.gosuslugi.dom.schema.integration.nsi_common_service.Fault;
import ru.gosuslugi.dom.schema.integration.nsi_common_service.NsiPortsType;
import ru.gosuslugi.dom.schema.integration.nsi_common_service.NsiService;

import com.ric.bill.DistServ;
import com.ric.bill.Utl;
import com.ric.st.NsiBindingBuilders;
import com.ric.st.SoapPreps;
import com.ric.st.excp.CantSendSoap;
import com.ric.st.excp.CantSignSoap;
import com.ric.st.impl.App;
import com.ric.st.impl.Config;
import com.ric.st.impl.LoggingSOAPHandler;
import com.ric.st.impl.SoapBuilder;
import com.sun.xml.ws.developer.WSBindingProvider;

@Service
@Slf4j
public class NsiBindingBuilder implements NsiBindingBuilders {

	@Autowired
	private ApplicationContext ctx;
    @PersistenceContext
    private EntityManager em;
	
	private NsiService service;
	private NsiPortsType port;
	private SoapBuilder sb; 

	private void setUp() throws CantSendSoap {
    	// создать сервис и порт
		service = new NsiService();
    	port = service.getNsiPort();

    	// подоготовительный объект для SOAP
    	SoapBuilder sb = ctx.getBean(SoapBuilder.class);
		sb.setUp((BindingProvider) port, (WSBindingProvider) port, true);
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
		// выполнить инициализацию
		setUp();

		ExportNsiListRequest req = new ExportNsiListRequest();
		req.setListGroup(grp);
		req.setId("foo");
		req.setVersion(req.getVersion());

		
		ExportNsiListResult ex = port.exportNsiList(req);
		return ex;
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
		// выполнить инициализацию
		setUp();
		
		ExportNsiItemRequest req = new ExportNsiItemRequest();
	    req.setListGroup(grp);
	    req.setRegistryNumber(id);
		req.setId("foo");
		req.setVersion(req.getVersion());
		
		ExportNsiItemResult ex = port.exportNsiItem(req);

		// освободить ресурсы
		//sb.closeResource();
	   return ex;
	}
}
