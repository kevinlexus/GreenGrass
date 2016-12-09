package com.ric.st.builder;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
import ru.gosuslugi.dom.schema.integration.nsi_common_service.NsiPortsType;
import ru.gosuslugi.dom.schema.integration.nsi_common_service.NsiService;

import com.ric.bill.Utl;
import com.ric.st.NsiBindingBuilders;
import com.ric.st.SoapPreps;
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
    	// заменить Endpoint, если надо 
    	if (config.isSrvTest()) {
    		sp.changeHost(config.getSrvTestHost());
    	}
    	// создать и подготовить заголовок запроса
    	sp.createRh(new Date(), Utl.getRndUuid(), config.getOrgPPGuid(), true);
	}


	/**
	 * Получение списка справочников
	 * @throws Exception
	 */
	public ExportNsiListResult getNsiList(String tp) throws Exception { 
		req = new ExportNsiListRequest();
		req.setListGroup(tp);
		req.setVersion(req.getVersion());
		port.exportNsiList(req);
	   	// отправить SOAP, анмаршаллинг результата
	    resList = (ExportNsiListResult) sp.sendSOAP(  // исправить
	   			req, 
	   			"exportNsiList", 			 		// исправить
	   			new ExportNsiListResult(),
	   			config);
	   return resList;
	}
	
	/**
	 * Получение справочника
	 * @throws Exception
	 * TypeList = (NSI,NSIRAO)
	 * TypeItem - код справочника
	 */
	public ExportNsiItemResult getNsiItem(String TypeList,BigInteger TypeItem) throws Exception {
		TypeList = "NSI";
	   	TypeItem =BigInteger.valueOf(30);	    	
	   	ExportNsiItemRequest req = new ExportNsiItemRequest();
	    req.setListGroup(TypeList);;
	   	port.exportNsiItem(req);
	   	// отправка SOAP, анмаршаллинг результата
	   	// Исправлять классы под соответствующий запрос!
	   	resItem = (ExportNsiItemResult) sp.sendSOAP(  // исправить
	   			req, 
	   			"ExportNsiList", 			 		// исправить
	   			new ExportNsiListResult(),
	   			config);
	
	   	
	   	for (NsiElementType ni : resItem.getNsiItem().getNsiElement()) {
	   		
	   		
	   	}
	   	
/*	   	for (NsiElementType ni : resItem.getNsiItem().getNsiElement()) {
	   		 Ulist nr_tab = new Ulist();
	    	 nr_tab.setTypref(TypeList);
	    	 nr_tab.setRegnum(TypeItem);
	    	 nr_tab.setCode(ni.getCode());
	    	 nr_tab.setS1(ni.getGUID());
	   		 nr_tab.setModified(ni.getModified().toGregorianCalendar().getTime());
	   		for (NsiElementFieldType nft : ni.getNsiElementField()) {
	   			nr_tab.setValue(nft.getName());
		   		}
	   		 System.out.println("code:"+ni.getCode());	
	   		 System.out.println("Guid:"+ni.getGUID());
	   		 System.out.println("Data modify:"+ni.getModified());
	   		 System.out.println("Data start:"+ni.getStartDate());
	   		 System.out.println("Data end:"+ni.getEndDate());
	   	    for (NsiElementFieldType nft : ni.getNsiElementField()) {
	   	     System.out.println("Name:"+nft.getName());
	   		}
		}
*/	   	System.out.println("res:"+resItem.getNsiItem());
	   return resItem;
	}
}
