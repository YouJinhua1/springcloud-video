package com.yjh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;
import feign.Logger;
import feign.Logger.Level;

@Configuration
public class FeignConfiguration1 {

	@Bean
	public Contract feignContract(){
		return new Contract.Default();
	}
	
	//配置feign日志打印的内容
	@Bean 
	public Level feignLoggerLevel(){
		//所有的日志都打印
		return Logger.Level.FULL;
	}
}
