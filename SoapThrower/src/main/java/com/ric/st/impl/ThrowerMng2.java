package com.ric.st.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.terracotta.modules.ehcache.async.AsyncConfig;

import com.ric.st.Throwers2;

@RunWith(SpringJUnit4ClassRunner.class) //только для JUnit, можно убрать!
@ContextConfiguration(classes = {AsyncConfig.class}) //только для JUnit, можно убрать!
@Service
public class ThrowerMng2 implements Throwers2{

	@Autowired
	private ApplicationContext ctx;
    @PersistenceContext
    private EntityManager em;
	@Autowired
	private Config config;

    
}
