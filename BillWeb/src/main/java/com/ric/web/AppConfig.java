package com.ric.web;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.ric.bill.Calc;

@Configuration
@ComponentScan({"com.ric.bill"})
@ImportResource("spring.xml")
@EnableCaching
@EnableAsync
public class AppConfig {
	
	@Bean 
	public RequestContextListener requestContextListener(){
		Calc.mess("Listener initialized", 1);
	    return new RequestContextListener();
	} 
	
}

