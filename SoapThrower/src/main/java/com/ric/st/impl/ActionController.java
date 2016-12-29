package com.ric.st.impl;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.gosuslugi.dom.schema.integration.house_management.ImportResult;
import ru.gosuslugi.dom.schema.integration.house_management_service.Fault;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiElementType;

import com.ric.st.ActionControllers;
import com.ric.st.RefStore;
import com.ric.st.builder.HouseManagementBindingBuilder;
import com.ric.st.excp.CantGetNSI;
import com.ric.st.excp.CantSendSoap;
import com.ric.st.hotora.dao.ActionDAO;
import com.ric.st.hotora.dao.EolinkDAO;
import com.ric.st.hotora.model.exs.Action;
import com.ric.st.mm.UlistMng;
import com.ric.st.prep.HouseManagementPreps;
import com.ric.st.prep.impl.HouseManagementPrep;

@Slf4j
@Service
public class ActionController implements ActionControllers {

	@Autowired
	private ActionDAO actionDao; 
	@Autowired
	private EolinkDAO eolinkDao;
	@Autowired
	private UlistMng ulistMng;
	@Autowired
	private Config config;
	@PersistenceContext
    private EntityManager em;
	@Autowired
	private HouseManagementBindingBuilder hb;

	/**
	 * Выполнить инициализацию объекта 
	 * @return 
	 * @throws EmptyStorable
	 */
	private boolean checkNsiUpdates() {
		// проверить обновление справочников
		try {
			ulistMng.refreshNsi("NSI");
			ulistMng.refreshNsi("NSIRAO");
		} catch (Exception e) {
			// сообщение об ошибке
			e.printStackTrace();
			return false;
		}
		return true;
	}


	/**
	 * Поиск новых действий для обработки 
	 */
	public void searchActions() {
		
		// загрузить конфиг
		config.setUp();
		
		
	
		log.info(" ********************** search Actions:");
		
		//Eolink eo = em.find(Eolink.class, 2);
		//Action ac = new Action(eo, "INS", "INS");
		//eo.getAction().add(ac);	
		
		// ОСНОВНОЙ ЦИКЛ
		for (Action ac: actionDao.getAllUnprocessed()) {
			String act = ac.getAction(); 
			String objTp = ac.getEolink().getAddrTp().getCd();

			if (objTp.equals("Дом")) {

				HouseManagementPreps hm = new HouseManagementPrep();
				hm.setCultHerit(false);
				hm.setFloorCount("14");
				hm.setHouseGuid("bdc2d006-7f83-4ab2-be27-30ae0b725ade");
				hm.setMinFloorCount(4);
				hm.setNoRSOGKNEGRP(true);
				hm.setOktmo("32607441101");
				hm.setState("Исправный");
				hm.setTotalSquare(1113D);
				hm.setUnderFloorCount("0");
				hm.setUsedYear(1984);
				hb.setHm(hm);
				
				if (act.equals("INS")) {
					// добавление дома
					ImportResult res = null;
					try {
						res = hb.createApartmentHouse();
					} catch (CantSendSoap | Fault e) {
						e.printStackTrace();
						log.info("Попытка добавления дома!");
						log.info("Ошибка добавления дома, выход!");
						return;
					}
					if (res.getErrorMessage() != null) {
						log.info("Результат:{}", res.getErrorMessage().getErrorCode());
					}
				} else if (act.equals("UPD")) {
					// обновление дома	
					ImportResult res = null;
					try {
						log.info("Попытка обновления дома!");
						res = hb.updateApartmentHouse();;
					} catch (CantSendSoap | Fault e) {
						e.printStackTrace();
						log.info("Ошибка обновления дома, выход!");
						return;
					}
					if (res.getErrorMessage() != null) {
						log.info("Результат:{}", res.getErrorMessage().getErrorCode());
					}

				}
				
				
			}

			
			log.info(" Action:{}, tp={}",ac.getAction(), ac.getEolink().getAddrTp().getCd());
		}
		
		
	}



}
