package com.ric.st.hotora.dao;

import java.util.List;

import com.ric.st.hotora.model.exs.Action;
import com.ric.st.hotora.model.scott.Kart;


public interface ActionDAO {

	public List<Action> getAllUnprocessed();
	
}
