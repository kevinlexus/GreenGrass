package com.ric.st.mm.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.extern.slf4j.Slf4j;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ru.gosuslugi.dom.schema.integration.nsi_base.NsiItemInfoType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiListType;
import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiListResult;

import com.ric.bill.Utl;
import com.ric.st.builder.NsiBindingBuilder;
import com.ric.st.hotora.dao.UlistDAO;
import com.ric.st.hotora.dao.impl.UlistDAOImpl;
//import com.ric.st.hotora.dao.EolinkDAO;
//import com.ric.st.hotora.model.exs.Eolink;
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


	private String getPrefixedCD(String cd, String grp) {
		return config.getPrefixGis()+"_"+grp+"_"+cd;
	}
	
//	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	/**
	 * Создать или обновить справочник NSI или NSIRAO
	 * @param lst
	 * @param nsiItem
	 * @param grp
	 */
	private void updNsiList(List<UlistTp> lst, NsiItemInfoType nsiItem, String grp) {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+7"));
		String prefix = getPrefixedCD(nsiItem.getRegistryNumber().toString(), grp);
		// найти заголовочный элемент справочника
		Optional<UlistTp> el = lst.stream()
				.filter(t-> t.getCd().equals(prefix))
				.findAny();
		if (!el.isPresent()) {
			// не найден заголовочный элемент, создать новый
			log.info("Создан заголовок :{}", prefix);
			LocalDateTime ldt =  new LocalDateTime(Utl.getDate(nsiItem.getModified()));

			DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:S z");
			String reportDate = df.format(Utl.getDate(nsiItem.getModified()));
			log.info("formatted date1 = {}", reportDate);
			
			UlistTp lstTp = new UlistTp(prefix, nsiItem.getName(), 
					ldt, 
					//new Date(), 
					grp, null);
			em.persist(lstTp);
		} else {
			// найден заголовок, проверить дату обновления
			//if (!el.get().getDt1().equals(Utl.getDate(nsiItem.getModified()))) {
			if (el.get().getDt1().toDate().getTime() != Utl.getDate(nsiItem.getModified()).getTime() ) {
				log.info("Обновить справочник: {}", prefix);
				log.info("2 = dt1={}, dt2={}", el.get().getDt1().toDate().getTime(), Utl.getDate(nsiItem.getModified()).getTime());
				
				//log.info("1 = dt1={}, dt2={}", el.get().getDt1(), Utl.getDate(nsiItem.getModified()));
				//log.info("2 = dt1={}, dt2={}", el.get().getDt1().toDate(), Utl.getDate(nsiItem.getModified()));

				/*DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:S z");
				String reportDate = df.format(el.get().getDt1());
				log.info("formatted date1 = {}", reportDate);
				reportDate = df.format(Utl.getDate(nsiItem.getModified()));
				log.info("formatted date2 = {}", reportDate);
				*/
				// обновить справочник (дата обновилась)
				
			} else {
				log.info("Всё пучком! {}", prefix);
			}
		}
		
	}
	
	/**
	 * Обновить NSI справочники
	 * @throws Exception 
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void refreshNsi(String grp) throws Exception {
		
		
		// получить из нашей базы 
		List<UlistTp> lst =  ulistDao.getByGrp(grp);
		lst.stream().forEach(t -> log.trace("Элемент из HOTORA: {}",t.getName()));
		ExportNsiListResult res = nsiBuilder.getNsiList(grp); //здесь не менять, это тип справочников
		
		res.getNsiList().getNsiItemInfo().stream().forEach(t -> log.trace("Элемент из списка справочников ГИС: {}",t.getName()));
		res.getNsiList().getNsiItemInfo().stream().forEach(t -> updNsiList(lst, t, grp));
		}
}
