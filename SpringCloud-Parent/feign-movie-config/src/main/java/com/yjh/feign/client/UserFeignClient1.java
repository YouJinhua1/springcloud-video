package com.yjh.feign.client;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.yjh.config.FeignConfiguration1;
import com.yjh.feign.entity.User;

import feign.Param;
import feign.RequestLine;

@FeignClient(name="feign-user",configuration=FeignConfiguration1.class)
public interface UserFeignClient1 {

	//使用feign原生的默认注解
	@RequestLine("GET /simple/{id}")
	public User findById(@Param("id") Long id);
	
	
}
