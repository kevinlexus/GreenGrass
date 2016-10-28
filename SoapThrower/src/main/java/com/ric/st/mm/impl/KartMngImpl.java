package com.ric.st.mm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ric.st.hotora.dao.KartDAO;
import com.ric.st.hotora.model.scott.Kart;
import com.ric.st.mm.KartMng;

@Service
public class KartMngImpl implements KartMng {

	@Autowired
	private KartDAO kDao;

	public List<Kart> getKart(String lsk) {
		return kDao.getKart(lsk);
	}
	
	
}