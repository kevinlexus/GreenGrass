package com.ric.bill.mm.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.ChrgServThr;
import com.ric.bill.Utl;
import com.ric.bill.dao.PayordCmpDAO;
import com.ric.bill.dao.PayordDAO;
import com.ric.bill.dao.PayordGrpDAO;
import com.ric.bill.dto.PayordCmpDTO;
import com.ric.bill.dto.PayordDTO;
import com.ric.bill.dto.PayordGrpDTO;
import com.ric.bill.mm.LstMng;
import com.ric.bill.mm.PayordMng;
import com.ric.bill.model.ar.Area;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.bs.Org;
import com.ric.bill.model.fn.Payord;
import com.ric.bill.model.fn.PayordCmp;
import com.ric.bill.model.fn.PayordGrp;
import com.ric.bill.model.tr.Serv;

@Service
@Slf4j
public class PayordMngImpl implements PayordMng {

    @PersistenceContext
    private EntityManager em;
	@Autowired
	private PayordDAO payordDao;
	@Autowired
	private PayordGrpDAO payordGrpDao;
	@Autowired
	private PayordCmpDAO payordCmpDao;
	@Autowired
	private LstMng lstMng;
	
	/**
	 * Получить все платежки
	 * @return
	 */
	public List<Payord> getPayordAll() {
		
		return payordDao.getPayordAll();
		
	}

	/**
	 * Получить платежки по Id группы
	 * @return
	 */
	public List<Payord> getPayordByPayordGrpId(Integer payordGrpId) {
		
		return payordDao.getPayordByPayordGrpId(payordGrpId);
		
	}

	/**
	 * Получить все группы платежек
	 * @return
	 */
	public List<PayordGrp> getPayordGrpAll() {
		
		return payordGrpDao.getPayordGrpAll();
		
	}

	// Сохранить платежку из DTO
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void savePayordDto(PayordDTO payordDTO) {
		Payord payord = em.find(Payord.class, payordDTO.getId());
    	payord.setName(payordDTO.getName());		
    	payord.setSelDays(payordDTO.getSelDays());
    	
    	if (payordDTO.getPeriodTpFk() != null) {
        	Lst periodTp = em.find(Lst.class, payordDTO.getPeriodTpFk());
        	payord.setPeriodTp(periodTp);
    	} else {
        	payord.setPeriodTp(null);
    	}
	}

	// Удалить группу платежек из DTO
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void delPayordGrpDto(PayordGrpDTO p) {
		PayordGrp pg = em.find(PayordGrp.class, p.getId());
		em.remove(pg);
	}

    // сохранить группу платежки из DTO
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void savePayordGrpDto(PayordGrpDTO p) {
		PayordGrp payordGrp = em.find(PayordGrp.class, p.getId());
		payordGrp.setName(p.getName());
	}

    // добавить группу платежки из DTO
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public PayordGrp addPayordGrpDto(PayordGrpDTO p) {
		PayordGrp payordGrp = new PayordGrp(p.getName());
		em.persist(payordGrp);
		return payordGrp;
	}

	// сохранить компонент платежки из DTO
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void savePayordCmpDto(PayordCmpDTO p) {
		PayordCmp pCmp = em.find(PayordCmp.class, p.getId());
		if (p.getAreaFk() != null) {
			Area area = em.find(Area.class, p.getAreaFk());	
			pCmp.setArea(area);
		} else {
			pCmp.setArea(null);
		}

		if (p.getOrgFk() != null) {
			Org org = em.find(Org.class, p.getOrgFk());	
			pCmp.setOrg(org);
		} else {
			pCmp.setOrg(null);
		}
		
		if (p.getServFk() != null) {
			Serv serv = em.find(Serv.class, p.getServFk());	
			pCmp.setServ(serv);
		} else {
			pCmp.setServ(null);
		}
		
	}

	/**
	 * Получить компоненты платежки по её ID
	 * @return
	 */
	public List<PayordCmp> getPayordCmpByPayordId(Integer payordId) {

		return payordCmpDao.getPayordCmpByPayordId(payordId);
		
	}

	/**
	 * Получить группу платежек по её ID
	 * @return
	 */
	public PayordGrp getPayordGrpById(Integer id) {

		return payordGrpDao.getPayordGrpById(id);
		
	}
	
}