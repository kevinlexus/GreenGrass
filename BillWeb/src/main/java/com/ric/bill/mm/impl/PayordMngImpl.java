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
import com.ric.bill.dao.PayordDAO;
import com.ric.bill.dto.PayordDTO;
import com.ric.bill.mm.LstMng;
import com.ric.bill.mm.PayordMng;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.fn.Payord;

@Service
@Slf4j
public class PayordMngImpl implements PayordMng {

    @PersistenceContext
    private EntityManager em;
	@Autowired
	private PayordDAO payordDao;
	@Autowired
	private LstMng lstMng;
	
	/**
	 * Получить все платежки
	 * @return
	 */
	public List<Payord> getPayordAll() {
		
		return payordDao.getPayordAll();
		
	}

	// сохранить платежку из DTO
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
	
}