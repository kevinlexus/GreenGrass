package com.ric.st.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import com.ric.st.builder.NsiBindingBuilder;
import com.ric.st.mm.UlistMng;

/*
 * Конфигуратор приложения! 
 * Этот класс нужен только для JUnit (без него приложение будет работать!)
 */
@Configuration
@ImportResource("spring.xml")
@ComponentScan(basePackages = {"com.ric.st"})
public class AppConfig {

	
}