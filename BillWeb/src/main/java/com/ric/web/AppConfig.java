package com.ric.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
//@ComponentScan({ "com.ric.bill" })
@Import(JPAConfigTwo.class)
public class AppConfig {
	
}