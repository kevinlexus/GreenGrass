package com.ric.bill;

import java.util.Set;

import com.ric.bill.model.tr.TarifKlsk;

public interface TarifContains extends Storable {

	public Set<TarifKlsk> getTarklsk();
	public void setTarklsk(Set<TarifKlsk> tarklsk);

}
