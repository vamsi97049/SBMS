package com.example.demo.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	public AppConfig() {
		System.out.println("AppConfig::0-ParamConstructorInvoked");
	}
}
