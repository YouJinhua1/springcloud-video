package com.yjh.ribbon.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.yjh.ribbon.entity.User;

@RestController
public class MovieController {

	@Resource
	private RestTemplate restTemplate;

	@Resource
	private LoadBalancerClient loadBalancerClient;

	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
		return this.restTemplate.getForObject("http://eureka-user-client/simple/" + id, User.class);
	}

	@GetMapping("/test")
	public String testDemo() {
		
		ServiceInstance serviceInstance = this.loadBalancerClient.choose("eureka-user-client");
		System.out.println("eureka-user-client111"+" : "+serviceInstance.getPort()+" : "+
				serviceInstance.getHost() + " : " +serviceInstance.getServiceId());

		ServiceInstance serviceInstance2 = this.loadBalancerClient.choose("eureka-user-client2");
		System.out.println("eureka-user-client222"+" : "+serviceInstance2.getPort()+" : "+
				serviceInstance2.getHost() + " : " +serviceInstance2.getServiceId());

		return "TestDemo";
	}

}
