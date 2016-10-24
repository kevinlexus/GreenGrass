package com.ric.mm;

import java.util.List;

import com.ric.hotora.model.fkv.LskGuid;
import com.ric.hotora.model.scott.Kart;


public interface LskGuidMng  {

	public List<LskGuid> getLskGuid(String lsk);
	
}