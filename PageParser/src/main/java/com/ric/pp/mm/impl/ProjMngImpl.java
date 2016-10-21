package com.ric.pp.mm.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ric.pp.dao.ProjDAO;
import com.ric.pp.mm.ProjMng;
import com.ric.pp.model.Proj;

@Service
public class ProjMngImpl implements ProjMng {

	@Autowired
	private ProjDAO projDao;

	/**
	 * Добавить проект в хранилище
	 */
	@Transactional
	public void addProj(Proj proj) {
		projDao.addProj(proj);
	}

	public Proj getProjByOuterId(Integer id) {
		return projDao.getProjByOuterId(id);
	}
}