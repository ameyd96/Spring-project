package com.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//set your configuration on auth object
		auth.inMemoryAuthentication()
		.withUser("blah")
		.password("blah")
		.roles("USER")
		.and()
		.withUser("foo")
		.password("foo")
		.roles("ADMIN");
		
		//if you want to add more user then use method chaining and use :
		//.and()
		//.withUser("foo")
		//.password("foo")
		//.roles("ADMIN")
		
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		
		return NoOpPasswordEncoder.getInstance();
		//NoOpPasswordEncoder is method only for testing purpose only returns palin text
	}
	//getPasswordEncoder() this method for creating hashcode or encoded password format

}
