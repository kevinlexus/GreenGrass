package com.ric.web;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/home", "/chrglsk", "/chrgall").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	  
	  auth.jdbcAuthentication().dataSource(dataSource)
	  	.passwordEncoder(passwordEncoder())
		.usersByUsernameQuery(
			"select cd as username, lower(hash) as password, 1 as enabled from sec.t_user where cd=?")
		.authoritiesByUsernameQuery(
			"select cd as username, 'no' as role from sec.t_user where cd=?");
	}
	
	@Bean
	public Md5PasswordEncoder passwordEncoder(){
		return new Md5PasswordEncoder();
	}
	
}
