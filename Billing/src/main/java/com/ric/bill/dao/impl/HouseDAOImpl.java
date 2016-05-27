package com.ric.bill.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.ric.bill.dao.HouseDAO;
import com.ric.bill.model.ar.House;


/*@NamedStoredProcedureQuery(
		name = "getReviews", 
		procedureName = "get_reviews", 
		resultClasses = House.class, 
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class), 
			@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class)
		}
	)*/
@Repository
public class HouseDAOImpl implements HouseDAO {

	//EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;
    
	@Cacheable("billCache")
	public List<House> findAll() {
		
/*		List<House> h = (List<House>) em.createNamedStoredProcedureQuery("getReviews").getResultList();
		for (House b : h) {
		
		}*/
/*    	Session sess = (Session) em.getDelegate();

    	long startTime = System.currentTimeMillis();
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
    	startTime = System.currentTimeMillis();
    	System.out.println("Check 2");
    	Query query = sess.createQuery("select t from House t left join fetch Kw k on t.id=k.fkHouse "
				+ " left join fetch Kart a on k.id=a.fkKw "
				+ " left join fetch Reg r on a.lsk=r.lsk "
				+ "where t.klsk = 187804");
    	List<House> lst =query.list(); 
    	for (House o : lst) {
			for (Kw kw : o.getKw()) {
				for (Kart kart : kw.getLsk()) {
						System.out.println("");
						System.out.println("Kart="+kart.getLsk());	
						for (Reg reg : kart.getReg()) {
				        	System.out.print(reg.getId()+";");
						}
				}
			}
			break;
		}
		System.out.println(" ");
    	endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("Part 2:"+totalTime);*/
		
/*    	System.out.println("Check 1");
    	Query query = sess.createQuery("select t from House t "
				+ " "
				+ "where t.klsk = 187804");
		System.out.println("Check 2");
    	List<House> lst =query.list(); 
		System.out.println("Check 2.1");
    	for (House o : lst) {
    		System.out.println("Check 3");
			for (Kw kw : o.getKw()) {
				for (Kart kart : kw.getLsk()) {
					System.out.println("Kart="+kart.getFio());	
		    		System.out.println("Check 3.1");
					for (Reg reg : kart.getReg()) {
						System.out.print("Reg="+reg.getDtReg());	
						//break;
					}

		    		System.out.println("Check 3.2");
					for (RegState regState : kart.getRegState()) {
						System.out.print("Reg="+regState.getDtReg());	
						//break;
					}
				//break;
				}
			//break;
			}
		}
    	System.out.println("Check 4");*/

//		return null;

		return em.createQuery("select t from House t "
				+ " "
				+ "where t.klsk = 187804").getResultList();
    	

	}

	
}
