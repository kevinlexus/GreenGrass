package com.ric.st.impl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/*
 * Конфигуратор приложения! 
 * Этот класс нужен только для JUnit (без него приложение будет работать!)
 */
@Configuration
@ImportResource("spring.xml")
@ComponentScan(basePackages = {"com.ric.st"})
public class AppConfig {

	
}