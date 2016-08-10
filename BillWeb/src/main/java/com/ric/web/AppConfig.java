package com.ric.web;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan({"com.ric.bill"})
@ImportResource("spring.xml")
@EnableCaching
public class AppConfig {
	

	
}
