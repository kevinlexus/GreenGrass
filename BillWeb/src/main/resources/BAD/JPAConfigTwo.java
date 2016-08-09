package com.ric.web;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration 
//@ComponentScan("com.concretepage")
@EnableTransactionManagement
public class JPAConfigTwo {  
	@Bean
	public JpaTransactionManager jpaTransMan(){
		JpaTransactionManager jtManager = new JpaTransactionManager(
				getEntityManagerFactoryBean().getObject());
		return jtManager;
	}
	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
		//lcemfb.setPackagesToScan("com.ric.bill");
		lcemfb.setPackagesToScan("com.ric.bill.model.bs");
		lcemfb.setDataSource(getDataSource());
		lcemfb.setPersistenceUnitName("localContainerEntity");
		LoadTimeWeaver loadTimeWeaver = new InstrumentationLoadTimeWeaver();
		lcemfb.setLoadTimeWeaver(loadTimeWeaver);
		return lcemfb;
	}
	
	@Bean
	public DataSource getDataSource() {
	       BasicDataSource dataSource = new BasicDataSource();
	       dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
	       dataSource.setUrl("jdbc:oracle:thin:@192.168.100.92:1521:DEVDB");
	       dataSource.setUsername("lev");
	       dataSource.setPassword("testtest1");
	       return dataSource;
	}
} 
