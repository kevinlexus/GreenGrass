package com.ric.st.hotora.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ric.st.hotora.dao.KartDAO;
import com.ric.st.hotora.model.scott.Kart;



@Repository
public class KartDAOImpl implements KartDAO {

	@PersistenceContext
    private EntityManager em;
    
    //конструктор
    public KartDAOImpl() {
    	
    }
    
    //вернуть лицевой счет
    public List<Kart> getKart(String lsk) {
			Query query =em.createQuery("from Kart t where t.lsk = :s1");
			query.setParameter("s1", lsk);
			return query.getResultList();
	}
    
    
}
