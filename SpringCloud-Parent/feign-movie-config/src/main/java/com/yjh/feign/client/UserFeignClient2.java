package com.yjh.feign.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yjh.config.FeignConfiguration2;

@FeignClient(name = "xxx", url = "http://localhost:8760/",configuration=FeignConfiguration2.class)
public interface UserFeignClient2 {

	
	//使用springmvc的注解
	@RequestMapping(value="/eureka/apps/{serviceName}",method=RequestMethod.GET)
	public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);
}
