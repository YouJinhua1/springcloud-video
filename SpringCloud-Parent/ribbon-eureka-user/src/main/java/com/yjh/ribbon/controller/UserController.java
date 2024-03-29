package com.yjh.ribbon.controller;

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
import com.yjh.ribbon.entity.User;
import com.yjh.ribbon.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EurekaClient eurekaClient;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping("/simple/{id}")
	public User findById(@PathVariable Long id){
		return this.userRepository.findOne(id);
	}
	
	@GetMapping("/eureka-instance")
	public String serviceURL(){
		InstanceInfo instance=this.eurekaClient.getNextServerFromEureka("eureka_userclient", false);
		return instance.getHomePageUrl();
	}
	
	@GetMapping("/instance-info")
	public ServiceInstance showInfo(){
		ServiceInstance localServiceInstance=this.discoveryClient.getLocalServiceInstance();
		return localServiceInstance;
	}

}
