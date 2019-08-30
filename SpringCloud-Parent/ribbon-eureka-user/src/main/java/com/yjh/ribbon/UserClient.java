package com.yjh.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class UserClient {

	public static void main(String[] args) {
		SpringApplication.run(UserClient.class, args);
	}
}
