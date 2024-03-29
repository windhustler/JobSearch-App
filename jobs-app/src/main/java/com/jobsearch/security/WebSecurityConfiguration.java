package com.jobsearch.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	// This method is used to configure authentication details
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
//	    auth.inMemoryAuthentication()
//        	.withUser("trevor")
//        	.password(getPasswordEncoder().encode("asdfasdf"))
//        	.authorities("ROLE_USER");
		
//	    auth
//	      .userDetailsService(userDetailsService)
//	      .passwordEncoder(getPasswordEncoder());
	        
	  }
	
	 @Override
	 protected void configure(HttpSecurity http) throws Exception {
	    http.csrf().disable()
	        .authorizeRequests()
	          .antMatchers("/login").permitAll()
	          .anyRequest().hasRole("USER").and()
	        .formLogin()
	          .defaultSuccessUrl("/dashboard")
	          .permitAll()
	          .and()
	        .logout()
	          .logoutUrl("/logout")
	          .permitAll();
	  }
}