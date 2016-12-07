package com.ric.st.hotora.dao;

import java.util.List;
import com.ric.st.hotora.model.exs.Ulist;


public interface UlistDAO {

	public List<Ulist> getByTp(String tp);
}
