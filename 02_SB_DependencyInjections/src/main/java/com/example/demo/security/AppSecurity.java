package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppSecurity {
	public AppSecurity() {
		System.out.println("AppSecurity::0-paramConstructor");
	}
	@Bean
	public AppSecurity getInstance() {
		return new AppSecurity();
	}
}
