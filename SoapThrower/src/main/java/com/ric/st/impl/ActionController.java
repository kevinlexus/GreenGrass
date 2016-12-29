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

				// подготовительный объект дома
				HouseManagementPreps hm = new HouseManagementPrep();

				hm.setCultHerit(false);
				hm.setFloorCount("15");
				hm.setHouseGuid("bdc2d006-7f83-4ab2-be27-30ae0b725ade");
				hm.setMinFloorCount(5);
				hm.setNoRSOGKNEGRP(true);
				hm.setOktmo("32607441101");
				hm.setState("Исправный");
				hm.setTotalSquare(1115D);
				hm.setUnderFloorCount("0");
				hm.setUsedYear(1985);
				hb.setHm(hm);
				
				if (act.equals("INS")) {
					// добавление дома
					hb.addHouse();
				
				} else if (act.equals("UPD")) {
					// обновление дома	
					hb.updHouse();

				}
				
				
			}

			
			log.info(" Action:{}, tp={}",ac.getAction(), ac.getEolink().getAddrTp().getCd());
		}
		
		
	}



}
