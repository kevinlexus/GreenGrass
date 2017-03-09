package com.ric.bill.mm.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ric.bill.Config;
import com.ric.bill.model.bs.Org;
import com.ric.bill.model.sec.Vsec;
import com.ric.bill.dao.OrgDAO;
import com.ric.bill.dao.VsecDAO;
import com.ric.bill.mm.SecMng;

@Service
public class SecMngImpl implements SecMng {

    @Autowired
	private VsecDAO vDao;
    @Autowired
	private OrgDAO orgDao;
    @Autowired
	private Config config;

	/**
	 * Получить список объектов по которым доступна привилегия по параметрам
	 * @param userCd - пользователь 
	 * @param roleCd - роль
	 * @param actCd - действие
	 */
	@Override
	public List<Vsec> getPrivByUserRoleAct(String userCd, String roleCd, String actCd) {
		
		return vDao.getPrivByUserRoleAct(userCd, roleCd, actCd);
	}

	
	/**
	 * Получить список организаций, доступных текущему пользователю по определенной роли, действию
	 * @param roleCd - роль
	 * @param actCd - действие
	 */
	@Override
	public List<Org> getOrgCurUser(String roleCd, String actCd) {
		//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//return auth.getName();

		//String userCd = auth.getName();
		String userCd = config.getCurUserCd();
		List<Org> lst = new ArrayList <Org>(); 
		vDao.getPrivByUserRoleAct(userCd, roleCd, actCd).stream().forEach(t -> 
				{
					Org org = orgDao.getByKlsk(t.getKlsk());
					if (org != null) {
						lst.add(org);
					}
				}
				);
		return lst;
	}

	
}