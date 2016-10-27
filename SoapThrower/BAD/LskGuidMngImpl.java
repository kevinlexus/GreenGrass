package com.ric.mm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ric.hotora.dao.KartDAO;
import com.ric.hotora.dao.LskGuidDAO;
import com.ric.hotora.model.fkv.LskGuid;
import com.ric.hotora.model.scott.Kart;
import com.ric.mm.KartMng;
import com.ric.mm.LskGuidMng;

@Service
public class LskGuidMngImpl implements LskGuidMng {

	@Autowired
	private LskGuidDAO lDao;

	public List<LskGuid> getLskGuid(String lsk) {
		return lDao.getLskGuid(lsk);
	}
	
	
}