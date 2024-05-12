package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private PasswordEncoder enc;

	// override the method : for supplying authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// configure in mem auth provider by supplying 3 details --user name , pwd ,
		// granted roles
		auth.inMemoryAuthentication().withUser("Rama").password(enc.encode("1234")).roles("ADMIN") // .authorities("ROLE_ADMIN")
				.and().withUser("Riya").password(enc.encode("12345")).roles("USER");

	}

	/*
	 * The default configuration is:
	 * http.authorizeRequests().anyRequest().authenticated().and().formLogin().and()
	 * .httpBasic();
	 * 
	 * 
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/home").permitAll() // /home : open
		.antMatchers("/user").hasAnyRole("ADMIN","USER") //protected api /user : accessible to admin n user
		.antMatchers("/admin").hasRole("ADMIN")
		.and()
		.httpBasic();// enables HTTP Basic authentication		
	}

}
