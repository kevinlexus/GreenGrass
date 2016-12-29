package com.ric.st.mm.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ru.gosuslugi.dom.schema.integration.nsi_base.NsiElementFieldType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiElementNsiRefFieldType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiElementNsiRefFieldType.NsiRef;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiElementStringFieldType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiElementType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiItemInfoType;
import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiItemResult;
import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiListResult;
import ru.gosuslugi.dom.schema.integration.nsi_common_service.Fault;

import com.diffplug.common.base.Errors;
import com.ric.bill.Utl;
import com.ric.st.builder.NsiBindingBuilder;
import com.ric.st.excp.CantGetNSI;
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
		// удалить элементы в нашей базе по данному справочнику
		ulistDao.delListByListTp(ulistTp);
		
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
						// создать новый элемент
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
								t.isIsActual(), ulistTp, idx, null, null, null, null, null
								);
						em.persist(main);
						log.info("Создана запись Code={}", Integer.valueOf(t.getCode()) );
						
						// создать записи fields в Ulist
						lst2.stream().forEach(d -> {

							// получить cd новой записи
							String fldCd = getPrefixedCD(id.toString(), grp, t.getCode());
							Ulist ulist = null;
							if (d.getClass().equals(NsiElementStringFieldType.class)) {
								NsiElementStringFieldType fld = (NsiElementStringFieldType) d;
								// создать запись в Ulist
								String name = null;
								if (fld.getName()==null || fld.getName().length()==0) {
									name = "------";
								} else {
									name = fld.getName();
								}
								ulist = new Ulist(fldCd, name, null, 
										null, null, null, ulistTp, idx, fld.getValue(), main, null, null, "ST"
										);
							} else if (d.getClass().equals(NsiElementNsiRefFieldType.class)) {
								NsiElementNsiRefFieldType fld = (NsiElementNsiRefFieldType) d;
								// создать запись в Ulist
								String name = null;
								if (fld.getName()==null || fld.getName().length()==0) {
									name = "------";
								} else {
									name = fld.getName();
								}
								NsiRef nRef = fld.getNsiRef();
								if (nRef != null) {
									ulist = new Ulist(fldCd, name, null, 
											null, null, null, ulistTp, idx, null, main, 
											nRef.getRef().getCode(), 
											nRef.getRef().getGUID(), "RF"
											);
								}
							}
							
							if (ulist!=null) {
								em.persist(ulist);
								log.info("Создан элемент справочника  List: {}", ulist.getName());
							}
							
							
						});
						log.info("Создан элемент справочника List :{}", cd);
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
		if (!nsiItem.getRegistryNumber().equals( new BigInteger("262") )) {
			//return;
		}

		String prefix = getPrefixedCD(nsiItem.getRegistryNumber().toString(), grp);
		// найти заголовочный элемент в нашей базе
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
	 * Получить справочник Nsi
	 * @param grp - группа, например NSI, NSIRAO
	 * @param id - идентификатор справочника
	 * @return
	 * @throws CantGetNSI
	 */
	public ExportNsiItemResult getNsi(String grp, BigInteger id) throws CantGetNSI {
		// получить из ГИС
		ExportNsiItemResult res;
		try {
			log.info("Запрос справочника grp={}, id={}", grp, id);
			res = nsiBuilder.getNsiItem(grp, id);
		} catch (Fault | CantSignSoap | CantSendSoap e1) {
			e1.printStackTrace();
			throw new CantGetNSI("Ошибка получения справочника NSI по группе grp="+grp);
		}
		return res;
	}
	
	/**
	 * Получить элемент справочника по соответствию полей имя и значение
	 * @param res - справочник
	 * @param name - имя искомого элемента
	 */
	public NsiElementType getNsiElem(ExportNsiItemResult res, String name, String value) {
		Optional<NsiElementType> elem = res.getNsiItem().getNsiElement().stream().filter(t -> 
					
					t.getNsiElementField().stream().filter(v -> v.getClass().equals(NsiElementStringFieldType.class) && v.getName().equals(name))
							.anyMatch(v -> ((NsiElementStringFieldType) v).getValue().equals(value))

				)
					
					.findFirst();
		if (elem.isPresent()) {
			return elem.get();
		} else {
			return null;
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
		// Обновить виды справочников
		// получить из нашей базы 
		List<UlistTp> lst =  ulistDao.getListTpByGrp(grp);
		// получить из ГИС
		ExportNsiListResult res;
		try {
			log.info("Запрос справочников группы grp={}", grp);
			res = nsiBuilder.getNsiList(grp);
		} catch (Fault | CantSignSoap | CantSendSoap e1) {
			e1.printStackTrace();
			throw new CantUpdNSI("Ошибка обновления группы справочников grp="+grp);
		}
		res.getNsiList().getNsiItemInfo().stream().forEach(t -> log.info("Заголовок справочника из ГИС: {}", t.getName()));
		// обработать каждый справочник
		res.getNsiList().getNsiItemInfo().stream().forEach(Errors.rethrow().wrap(t -> {updNsiList(lst, t, grp);}));

	}
}
