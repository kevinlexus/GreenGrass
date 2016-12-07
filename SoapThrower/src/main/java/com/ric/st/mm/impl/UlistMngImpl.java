package com.ric.st.mm.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ru.gosuslugi.dom.schema.integration.nsi_base.NsiItemInfoType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiListType;
import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiListResult;

import com.ric.st.hotora.dao.UlistDAO;
import com.ric.st.hotora.dao.impl.UlistDAOImpl;
//import com.ric.st.hotora.dao.EolinkDAO;
//import com.ric.st.hotora.model.exs.Eolink;
import com.ric.st.hotora.model.exs.Ulist;
import com.ric.st.impl.NsiBindingBuilder;
import com.ric.st.mm.UlistMng;


@Slf4j
@Service
/**@throws Exception*/
public class UlistMngImpl implements UlistMng {

	@Autowired
	UlistDAO ulistDao; 

	@Autowired
	NsiBindingBuilder nsiBuilder;
	
	@PersistenceContext
    private EntityManager em;


	/**
	 * Обновить NSI справочники
	 * @throws Exception 
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void refreshNsi() throws Exception {
		// получить из нашей базы 
		List<Ulist> lst =  ulistDao.getByTp("11");
		lst.stream().forEach(t -> log.info("Элемент из HOTORA: {}",t.getName()));

		ExportNsiListResult res = nsiBuilder.getNsiList("NSI");
		res.getNsiList().getNsiItemInfo().stream().forEach(t -> log.info("Элемент из списка справочников ГИС: {}",t.getName()));
		
/*		NsiBindingBuilder hBb = new NsiBindingBuilder();
		ExportNsiListResult ensilr = hBb.getNsiList("NSI");
		
		for (NsiItemInfoType nli : ensilr.getNsiList().getNsiItemInfo()) {
			BigInteger rn = nli.getRegistryNumber();
							JAVA 8!!!	
					 * mLog.getVol().parallelStream()
						                .filter(t -> Utl.nvl(t.getStatus(), 0).equals(status) &&
						            			Utl.between(t.getDt1(), dt1, dt2) && //внимание! здесь фильтр берет даты снаружи!
						        				Utl.between(t.getDt2(), dt1, dt2))
						                .filter(t -> t.getTp().getCd().equals("Фактический объем"))
						                .forEach(t -> lnkVol.addVol(t.getVol1()));
							
					
		}
*/
		}



}
