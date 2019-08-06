package com.zc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class SpringcloudEurekaApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringcloudEurekaApplication.class, args);
	}

}
