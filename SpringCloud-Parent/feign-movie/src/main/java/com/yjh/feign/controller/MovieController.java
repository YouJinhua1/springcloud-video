package com.yjh.feign.controller;


import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yjh.feign.client.UserFeignClient;
import com.yjh.feign.entity.User;

@RestController
public class MovieController {

	
	@Resource
	private UserFeignClient userFeignClient;

	@GetMapping("/user/{id}")
	public User findById(@PathVariable Long id) {
		return userFeignClient.findById(id);
	}
	
	@GetMapping("/testPost")
	public User tetPost(User user) {
		return this.userFeignClient.postUser(user);
	}
	
	@GetMapping("/testGet")
	public User getGet(User user){
		return this.userFeignClient.getUser(user);
	}


}
