package com.ric.st;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ric.bill.model.bs.Serv;

import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiItemResult;


/*
 * Хранилище справочников, полученных от ГИС
 */
public class RefStore {
    private Map<String, ExportNsiItemResult> mapRef;

    // конструктор
    public RefStore() {
    	mapRef = new HashMap<String, ExportNsiItemResult>();
    }
    
	/**
	 * Добавить справочник в хранилище
	 * @param res - справочник
	 * @param grp - группа
	 */
	public void add(ExportNsiItemResult res, String grp) {
		mapRef.put(grp, res);
	}
	
	/**
	 * Получить справочник по группе и коду
	 * @param grp - группа
	 * @return 
	 * @return 
	 */
	public ExportNsiItemResult getByGrp(String grp, BigInteger id) {
    	Optional<Entry<String, ExportNsiItemResult>> res = mapRef.entrySet().stream().filter(t -> t.getKey().equals(grp))
    		.filter(t -> t.getValue().getNsiItem().getNsiItemRegistryNumber().equals(id))
    		.findAny();
		return res.get().getValue();
	}
}
