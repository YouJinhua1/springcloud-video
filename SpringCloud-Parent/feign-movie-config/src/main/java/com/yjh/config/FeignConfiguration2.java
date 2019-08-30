package com.yjh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;
import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class FeignConfiguration2 {

	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
		return new BasicAuthRequestInterceptor("user","123");
	}
	
}
