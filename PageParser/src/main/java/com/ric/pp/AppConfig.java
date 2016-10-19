package com.ric.pp;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@ComponentScan({"com.ric.pp"})
@ImportResource("spring.xml") 
public class AppConfig {
	

	
}
