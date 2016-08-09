package com.ric.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
//@EnableJpaRepositories(basePackages = "com.ric.bill.dao.impl")
//@EnableJpaRepositories(basePackages = "com.ric.web")
@ComponentScan({"com.ric.bill", "com.ric.bill.dao.impl", "com.ric.bill.mm.impl", "com.ric.web"})
public class BillWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillWebApplication.class, args);
	}
}
