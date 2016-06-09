package com.ric.bill.mm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.dao.ParDAO;
import com.ric.bill.mm.ParMng;
import com.ric.bill.model.bs.Par;

@Service
@Cacheable("billCache")
public class ParMngImpl implements ParMng {

	@Autowired
	private ParDAO pDao;

	@Transactional
	public List<Par> findAll() {
		return pDao.findAll();
	}

	/**
	 * Узнать существует ли параметр по его CD
	 */
	@Transactional
	public boolean isExByCd(String cd) {
		for (Par p: findAll()){
			if (p.getCd().equals(cd)){
				return true;
			}
		}
		return false;
	}

}