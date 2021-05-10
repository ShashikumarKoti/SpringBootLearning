package com.skoti.learning.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
    private DataSource ds;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

	@Autowired
	public  void configureAMBuilder(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(ds)
        .authoritiesByUsernameQuery("select name, role from Users_Details where name=?")
        .usersByUsernameQuery("select name, password, 1 as enabled  from Users_Details where name=?");
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .httpBasic()
        .and()
        .authorizeRequests()
        .anyRequest().authenticated();
		 http.csrf().disable();
	}
}
