package com.ric.st.mm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ric.st.hotora.dao.KartDAO;
import com.ric.st.hotora.model.scott.Kart;
import com.ric.st.mm.impl.KartMngImpl;

@Service
public class KartMng implements KartMngImpl {

	@Autowired
	private KartDAO kDao;

	public List<Kart> getKart(String lsk) {
		return kDao.getKart(lsk);
	}
	
	
}