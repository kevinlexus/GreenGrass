package com.ric.web;

import java.lang.management.ManagementFactory;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableCaching
public class BillWebApplication {

	private static ApplicationContext applicationContext = null;
	
	public static void main(String[] args) {
        String mode = args != null && args.length > 0 ? args[0] : null;

        if (applicationContext != null && mode != null && "stop".equals(mode)) {
            System.exit(SpringApplication.exit(applicationContext, new ExitCodeGenerator() {
                @Override
                public int getExitCode() {
                    return 0;
                }
            }));
        }
        else {
            SpringApplication app = new SpringApplication(BillWebApplication.class);
            applicationContext = app.run(args);
        }
    }	
}
