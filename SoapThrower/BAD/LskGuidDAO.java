package com.ric.hotora.dao;

import java.util.List;

import com.ric.hotora.model.fkv.LskGuid;
import com.ric.hotora.model.scott.Kart;


public interface LskGuidDAO {

	public List<LskGuid> getLskGuid(String lsk);
	
}
