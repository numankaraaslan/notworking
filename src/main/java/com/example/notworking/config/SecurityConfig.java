package com.example.notworking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig
{
	@Bean
	SecurityFilterChain chain(HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity.sessionManagement(c -> c.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		httpSecurity.csrf(c -> c.disable());
		httpSecurity.userDetailsService(getUserDetailsService());
		return httpSecurity.build();
	}

	private UserDetailsService getUserDetailsService()
	{
		InMemoryUserDetailsManager imudm = new InMemoryUserDetailsManager();
		imudm.createUser(User.builder().username("user").password("noop1234").roles("ADNIN").build());
		return imudm;
	}
}