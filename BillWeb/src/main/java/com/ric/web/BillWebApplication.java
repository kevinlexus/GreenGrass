package com.ric.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class BillWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillWebApplication.class, args);
	}
}
