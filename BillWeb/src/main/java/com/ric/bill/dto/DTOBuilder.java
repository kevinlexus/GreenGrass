package com.ric.bill.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.fn.Payord;

/**
 * Построитель DTO объектов
 * @author lev
 *
 */
@Service
public class DTOBuilder {


/**
 * Построить коллекцию DTO платежек	
 * @param lst
 * @return
 */
public List<PayordDTO> getPayordDTOLst(List<Payord> lst) {
	List<PayordDTO> lst2 = new ArrayList<PayordDTO>(0);
	lst.stream().forEach(t-> lst2.add(
				new PayordDTO(t.getId(), t.getName(), (t.getPeriodTp()!=null) ? t.getPeriodTp().getId() : null, t.getSelDays(), t.getUsername(), t.getDtf())
				));
	return lst2;
}

/**
 * Построить коллекцию DTO списка (Lst)
 * @param lst
 * @return
 */
public List<LstDTO> getLstDTOLst(List<Lst> lst) {
	List<LstDTO> lst2 = new ArrayList<LstDTO>(0);
	lst.stream().forEach(t-> lst2.add(
				new LstDTO(t.getId(), t.getCd(), t.getName())
				));
	return lst2;
}

	
}