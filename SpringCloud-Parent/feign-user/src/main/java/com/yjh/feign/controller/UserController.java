package com.yjh.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.yjh.feign.entity.User;
import com.yjh.feign.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@GetMapping("/simple/{id}")
	public User findById(@PathVariable Long id){
		return this.userRepository.findOne(id);
	}
	
	@PostMapping("/user")
	public User postUser(@RequestBody User user){
		return user;
	}
	
	//该请求不会成功，应为接收的参数是对象，那么即使使用的是@GetMapping也会是Post请求
	@GetMapping("/get-user")
	public User getUser(User user){
		return user;
	}

}
