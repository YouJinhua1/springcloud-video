package com.yjh.hystrix.controller;

import javax.annotation.Resource;

import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yjh.hystrix.entity.User;

@RestController
public class MovieController {

	@Resource
	private RestTemplate restTemplate;

	@Resource
	private LoadBalancerClient loadBalancerClient;

	@GetMapping("/movie/{id}")
	@HystrixCommand(fallbackMethod="findByIdFallback")
	public User findById(@PathVariable Long id) {
		return this.restTemplate.getForObject("http://eureka-user-client/simple/" + id, User.class);
	}
	
	/**
	 * fallbask函数的参数和返回值必须和上面的一致
	 * @param id
	 * @return
	 */
	public User findByIdFallback(Long id){
		User user=new User();
		user.setId(0L);
		user.setUsername("fallback");
		return user;
	}
	

}
