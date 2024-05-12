package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity //mandatory
@Configuration //mandatory
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	//dep : password encoder
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private UserDetailsService userDetailsService;

	//configure auth provider builder to build in mem auth provider
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//configure in mem auth provider : user name , pwd , roles/authorities
//		auth.inMemoryAuthentication()
//		.withUser("Kiran").password(encoder.encode("abc1234")).roles("USER")
//		.and()
//		.withUser("Risha").password(encoder.encode("def1234")).roles("ADMIN");
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
	}
	//configuration for role based authorization
	/*
	 * http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
	 * 
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/user").hasAnyRole("USER","ADMIN")		
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/home").permitAll()
		.and()
		.httpBasic();		
	}
	

	
}
