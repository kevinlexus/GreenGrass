package com.ric.web;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@EnableCaching
@ComponentScan({ "com.ric.bill" })
@ImportResource("classpath:spring.xml")
public class AppConfig {



}