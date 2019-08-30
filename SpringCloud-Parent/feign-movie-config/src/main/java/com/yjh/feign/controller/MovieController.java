package com.yjh.feign.controller;


import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yjh.feign.client.UserFeignClient1;
import com.yjh.feign.client.UserFeignClient2;
import com.yjh.feign.entity.User;

@RestController
public class MovieController {

	
	@Resource
	private UserFeignClient1 userFeignClient1;
	
	@Resource
	private UserFeignClient2 userFeignClient2;

	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
		return userFeignClient1.findById(id);
	}
	
	@GetMapping("/{serviceName}")
	public String findServiceInfoFromEurekaByServiceName(@PathVariable String serviceName){
		return this.userFeignClient2.findServiceInfoFromEurekaByServiceName(serviceName);
	}
	


}
