package com.zc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SimpleProvider1Application {

	public static void main(String[] args) {
		SpringApplication.run(SimpleProvider1Application.class, args);
	}

}
