package com.ric.st;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
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
	private List<Row> mapRef;
    
    // вложенный класс - запись 
    private class Row {
    	private String grp; // группа справочника
    	private BigInteger id; // id справочника
    	private ExportNsiItemResult res; // справочник
    	// конструктор
    	public Row (ExportNsiItemResult res, String grp, BigInteger id) {
    		this.setRes(res);
    		this.setGrp(grp);
    		this.setId(id);
    	}
		public String getGrp() {
			return grp;
		}
		public void setGrp(String grp) {
			this.grp = grp;
		}
		public BigInteger getId() {
			return id;
		}
		public void setId(BigInteger id) {
			this.id = id;
		}
		public ExportNsiItemResult getRes() {
			return res;
		}
		public void setRes(ExportNsiItemResult res) {
			this.res = res;
		}
    }
    
    // конструктор
    public RefStore() {
    	mapRef = new ArrayList<Row>();
    }
    
	/**
	 * Добавить справочник в хранилище
	 * @param res - справочник
	 * @param grp - группа
	 */
	public void add(ExportNsiItemResult res, String grp, BigInteger id) {
		mapRef.add(new Row(res, grp, id));
	}
	
	/**
	 * Получить справочник по группе и коду
	 * @param grp - группа
	 * @return 
	 * @return 
	 */
	public ExportNsiItemResult getByGrpId(String grp, BigInteger id) {
    	Optional<Row> res = mapRef.stream().filter(t -> t.getGrp().equals(grp))
    		.filter(t -> t.getId().equals(id))
    		.findAny();
		return res.get().getRes();
	}
}
