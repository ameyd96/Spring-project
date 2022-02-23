package com.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		//created default schema with user table and values
		.dataSource(dataSource) ; //embeded dataabse H2 .by default any database u use it will point to it
//		.withDefaultSchema()
//		.withUser(
//				User.withUsername("user")
//				.password("pass")
//				.roles("USER")
//				)
//		.withUser(
//				User.withUsername("admin")
//				.password("pass")
//				.roles("ADMIN")
//				);
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//method is used to grant access of URL to perticular role.
				http.authorizeRequests()
				.antMatchers("/admin").hasRole("ADMIN")  //permit for ADMIN role
				.antMatchers("/user").hasAnyRole("USER","ADMIN")   //permit for USER role
				.antMatchers("/").permitAll()  //permit for every role
				
				.and().formLogin();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	

}
