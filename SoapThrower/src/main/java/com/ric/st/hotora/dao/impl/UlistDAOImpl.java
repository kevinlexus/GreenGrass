package com.ric.st.hotora.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ric.bill.model.bs.Lst;
import com.ric.st.hotora.dao.UlistDAO;
import com.ric.st.hotora.model.exs.Ulist;



@Repository
public class UlistDAOImpl implements UlistDAO {

	@PersistenceContext
    private EntityManager em;

	//конструктор
    public UlistDAOImpl() {
    	
    }

    // Получить список элементов справочника по типу
    public List<Ulist> getByTp(String tp) {
		Query query =em.createQuery("select t from Ulist t left join fetch t.ulistTp tp where tp.grp=:grp");
		query.setParameter("grp", tp);
		return query.getResultList();
    }
        
}
