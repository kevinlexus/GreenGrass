package com.ric.web;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*<context:component-scan base-package="com.ric.bill" />
<context:component-scan base-package="com.ric.bill.dao.impl" />
<context:component-scan base-package="com.ric.bill.mm.impl" />
*/
@Configuration
@EnableAutoConfiguration
//@ComponentScan({"com.ric.bill.ar"}) //-если убрать - не найдёт бины, например billServ
//@EntityScan(basePackages = "com.ric.bill.model.ar")
//@EnableJpaRepositories(basePackages = "com.ric.bill.model.ar")
//@ComponentScan({"com.ric.bill", "com.ric.bill.dao.impl", "com.ric.bill.mm.impl"})
@Import(JPAConfigTwo.class)
public class AppConfig {
	
}