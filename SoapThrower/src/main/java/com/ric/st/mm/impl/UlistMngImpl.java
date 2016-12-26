package com.ric.st.mm.impl;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ru.gosuslugi.dom.schema.integration.nsi_base.NsiElementFieldType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiElementStringFieldType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiElementType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiItemInfoType;
import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiItemResult;
import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiListResult;
import ru.gosuslugi.dom.schema.integration.nsi_common_service.Fault;

import com.diffplug.common.base.Errors;
import com.ric.bill.Utl;
import com.ric.st.builder.NsiBindingBuilder;
import com.ric.st.excp.CantSendSoap;
import com.ric.st.excp.CantSignSoap;
import com.ric.st.excp.CantUpdNSI;
import com.ric.st.hotora.dao.UlistDAO;
import com.ric.st.hotora.model.exs.Ulist;
import com.ric.st.hotora.model.exs.UlistTp;
import com.ric.st.impl.Config;
import com.ric.st.mm.UlistMng;


@Slf4j
@Service
/**@throws Exception*/
public class UlistMngImpl implements UlistMng {

	@Autowired
	UlistDAO ulistDao; 
	@Autowired
	NsiBindingBuilder nsiBuilder;
	@Autowired
	private Config config;
	
	@PersistenceContext
    private EntityManager em;

	private int idx=0;
	
	// префикс для элементов справочника
	private String getPrefixedCD(String cd, String grp, String code) {
		return getPrefixedCD(cd, grp)+"_"+code+"_"+idx++;
	}

	// префикс для заголовка справочника
	private String getPrefixedCD(String cd, String grp) {
		return config.getPrefixGis()+"_"+grp+"_"+cd;
	}
	
	// узнать можно ли параллельно вызывать, не будет ли concurrent excp?
	private void updNsiItem(UlistTp ulistTp, String grp, BigInteger id) throws CantUpdNSI {
		// получить элементы справочника из нашей базы 
		List<Ulist> lst =  ulistDao.getListByGrpId(grp, id);
		// получить из ГИС справочник
		ExportNsiItemResult res;
		try {
			res = nsiBuilder.getNsiItem(grp, id);
		} catch (Fault  e) {
			e.printStackTrace();
			throw new CantUpdNSI("Ошибка при обновлении справочника NSI grp="+ grp+", id="+ id);
		} catch (CantSignSoap e) {
			e.printStackTrace();
			throw new CantUpdNSI("Ошибка при обновлении справочника NSI grp="+ grp+", id="+ id);
		} catch (CantSendSoap e) {
			e.printStackTrace();
			throw new CantUpdNSI("Ошибка при обновлении справочника NSI grp="+ grp+", id="+ id);
		} 
		
		if (res.getErrorMessage() == null) {
			log.info("Есть элементы в базе ГИС по справочнику grp={}, id={}", grp, id);
			
			res.getNsiItem().getNsiElement().stream().forEach(t ->
				{
					// получить cd новой записи
					String cd = getPrefixedCD(id.toString(), grp, t.getCode());
					// найти элемент в нашей базе
					Optional<Ulist> el = lst.stream()
							.filter(v-> v.getCd().equals(cd))
							.findAny();
					
					if (!el.isPresent()) {
						// не найден элемент, создать новый
						List<NsiElementFieldType> lst2 =  t.getNsiElementField();

						// создать запись главного элемента с CD в Ulist
						log.info("Check1={}", Utl.nvl(t.getCode(), "-------"));
						String code = null;
						if (t.getCode()==null || t.getCode().length()==0) {
							code = "------";
						} else {
							code = t.getCode();
						}
						Ulist main = new Ulist(cd, code, t.getGUID(), 
								Utl.getDateFromXmlGregCal(t.getStartDate()), Utl.getDateFromXmlGregCal(t.getEndDate()),
								t.isIsActual(), ulistTp, idx, null, null
								);
						em.persist(main);
						log.info("Создана запись Code={}", Integer.valueOf(t.getCode()) );
						
						// создать записи fields в Ulist
						lst2.stream().forEach(d -> {

							// получить cd новой записи
							String fldCd = getPrefixedCD(id.toString(), grp, t.getCode());
							if (d.getClass().equals(NsiElementStringFieldType.class)) {
								NsiElementStringFieldType fld = (NsiElementStringFieldType) d;
								// создать запись в Ulist
								//log.info("Check2={}, {} ", fld.getValue(), Utl.nvl(fld.getValue(), "-------"));
								String name = null;
								if (fld.getName()==null || fld.getName().length()==0) {
									name = "------";
								} else {
									name = fld.getName();
								}
								Ulist ulist = new Ulist(fldCd, name, null, 
										null, null, null, ulistTp, idx, fld.getValue(), main
										);
								em.persist(ulist);
								log.info("Создан элемент справочника  List: {}", fld.getValue());
							}
							
							
						});
						
						//for (NsiElementFieldType n: lst2) {
							
							
						//}
						
						
						log.info("Создан элемент справочника List :{}", cd);
					} else {
						// найден элемент, проверить дату обновления
						log.info("Обновлён элемент справочника List :{}", cd);
						
					}
					
			    });
		} else {
			log.info("Нет элементов в базе ГИС по справочнику grp={}, id={}", grp, id);
		}
	}
	
	/**
	 * Создать или обновить справочник NSI или NSIRAO
	 * @param lst
	 * @param nsiItem
	 * @param grp
	 * @throws CantUpdNSI 
	 * @throws Exception 
	 */
	private void updNsiList(List<UlistTp> lst, NsiItemInfoType nsiItem, String grp) throws CantUpdNSI {
		// по каким то причинам не загружается справочник № 70
		if (nsiItem.getRegistryNumber().equals( new BigInteger("70") )) {
			return;
		}
		// пока работать только со справочником 
		if (!nsiItem.getRegistryNumber().equals( new BigInteger("32") )) {
			return;
		}

		String prefix = getPrefixedCD(nsiItem.getRegistryNumber().toString(), grp);
		// найти элемент в нашей базе
		Optional<UlistTp> el = lst.stream()
				.filter(t-> t.getCd().equals(prefix))
				.findAny();
		if (!el.isPresent()) {
			// не найден элемент, создать новый
			UlistTp lstTp = new UlistTp(prefix, nsiItem.getRegistryNumber().intValue(), nsiItem.getName(), 
					Utl.getDateFromXmlGregCal(nsiItem.getModified()),
					grp, null);
			em.persist(lstTp);
			log.info("Создан заголовочный элемент ListTp :{}", prefix);
			// обновить элементы справочника
			updNsiItem(lstTp, grp, nsiItem.getRegistryNumber());
			log.info("Создан справочник: {}", prefix);
		} else {
			// найден элемент, проверить дату обновления
			if (el.get().getDt1() == null || el.get().getDt1().getTime() != Utl.getDateFromXmlGregCal(nsiItem.getModified()).getTime()) {

				// обновить элементы справочника
				updNsiItem(el.get(), grp, nsiItem.getRegistryNumber());
				// установить дату обновления
				el.get().setDt1(Utl.getDateFromXmlGregCal(nsiItem.getModified()));
				log.info("Обновлён справочник: {}", prefix);
			}
			
			//проверить Name
			if (!el.get().getName().equals(nsiItem.getName())) {
				//обновить Name
				el.get().setName(nsiItem.getName());
				log.info("Обновлён заголовочный элемент, Name справочника: {}", prefix);
				
			}
			
		}
		
	}
	
	/**
	 * Обновить NSI справочники
	 * @return 
	 * @throws CantSendSoap 
	 * @throws CantSignSoap 
	 * @throws Fault 
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void refreshNsi(String grp) throws CantUpdNSI {
		
		//********* проверка не удалять! ***************
		//Ulist lst = em.find(Ulist.class, 25713660);
		//log.info("Ulist.cd={}",lst.getCd());
		// получить из ГИС справочник

/*		ExportNsiItemResult res2;
		try {
			res2 = nsiBuilder.getNsiItem("NSIRAO", BigInteger.valueOf(71));
		} catch (Exception e) {
			e.printStackTrace();
			log.info("ОШИБКА при обновлении справочника NSI!!!");
			throw new CantUpdNSI("Ошибка при обновлении справочника NSI!!!");
		}
		
		for (NsiElementType e: res2.getNsiItem().getNsiElement()){

			log.info("CHECK1 = {}", e.getCode());
			
			for (NsiElementFieldType nef :  e.getNsiElementField()) {
				log.info("CHECK2 field name = {}", nef.getName());
				log.info("CHECK2 field class = {}", nef.getClass());
				if (nef.getClass().equals(NsiElementStringFieldType.class)) {
					NsiElementStringFieldType ns = (NsiElementStringFieldType) nef;
					log.info("CHECK3 field name = {}", ns.getName());
					log.info("CHECK3 field value = {}", ns.getValue());
					
				}
			}
			
		}
		
		if (1==1) {
			return;
		} 
		*/
		
		// Обновить виды справочников
		// получить из нашей базы 
		List<UlistTp> lst =  ulistDao.getListTpByGrp(grp);
		// получить из ГИС
		ExportNsiListResult res;
		try {
			log.info("Запрос заголовков справочников");
			res = nsiBuilder.getNsiList(grp);
		} catch (Fault | CantSignSoap | CantSendSoap e1) {
			e1.printStackTrace();
			throw new CantUpdNSI("Ошибка обновления справочника NSI");
		}
		res.getNsiList().getNsiItemInfo().stream().forEach(t -> log.info("Элемент из списка справочников ГИС: {}",t.getName()));
		// обработать каждый справочник
		res.getNsiList().getNsiItemInfo().stream().forEach(Errors.rethrow().wrap(t -> {updNsiList(lst, t, grp);}));

	}
}
