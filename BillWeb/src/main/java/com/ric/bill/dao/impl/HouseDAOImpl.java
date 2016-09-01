package com.ric.bill.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Repository;

import com.ric.bill.Calc;
import com.ric.bill.Result;
import com.ric.bill.ResultSet;
import com.ric.bill.dao.HouseDAO;
import com.ric.bill.model.ar.House;



@Repository
public class HouseDAOImpl implements HouseDAO {

	//EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;
    
    static final String STATEMENT_SQLMAP = "Statement-SQL-Mapping";
    
	public List<House> findAll() {
		return em.createQuery("select t from House t "
				+ "where t.klsk in (-1)").getResultList(); //

	}

	public List<House> findAll2() {
		@SqlResultSetMapping(name= STATEMENT_SQLMAP, classes = { //эту часть кода можно закинуть в любое место
		        @ConstructorResult(targetClass = ResultSet.class,
		            columns = {
		                @ColumnResult(name="id",type = Integer.class)
		            }
		        )
		    }) @Entity class SQLMappingCfgEntity{@Id int id;} // <- walkaround

		Query q;
		List<House> lstHouse = null;
		try {
		Calc.mess("Query1"+Calc.getCurDt1().toLocaleString(), 2);
			q = em.createNativeQuery("select distinct h.id "+
						   "from ar.house h, ar.lskxorg x, ar.kart k, ar.kw kw, bs.org o "+
						   "where k.fk_kw = kw.id "+
						   "and k.lsk = x.lsk "+
						   "and o.reu in ('Z4', 'D8', 'F4', 'J4', 'G4') "+
						   "and x.fk_org = o.id "+
						   "and ? between x.dt1 and x.dt2 "+
						   "and kw.fk_house = h.id "+
						   "order by h.id ",  STATEMENT_SQLMAP);
			q.setParameter(1, Calc.getCurDt1(), TemporalType.DATE);
			
			List<ResultSet> lst = q.getResultList();
			lstHouse = new ArrayList<House>();
			for (ResultSet rs: lst) {
				Calc.mess("Found house id="+rs.getId(), 2);
				lstHouse.add(em.find(House.class, rs.getId()));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lstHouse;
		
	}
}
