package com.yjh.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.yjh.config.RibbonConfig;

@EnableEurekaClient
@SpringBootApplication
@RibbonClient(name="eureka-user-client",configuration=RibbonConfig.class)
public class MovieClientWithoutEureka {

	
	/**
	 * 如何解决硬编码：
	 *		              使用添加@LoadBalanced注解后的RestTemplate调用服务提供者的接口时，
	 *			    可以使用虚拟IP替代真实IP地址。所谓的虚拟IP就是服务提供者在
	 *			  application.properties或yml文件中配置的spring.application.name属性的值
	 * @return
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieClientWithoutEureka.class, args);
	}
}
