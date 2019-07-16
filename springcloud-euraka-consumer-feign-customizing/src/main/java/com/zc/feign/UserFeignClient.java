package com.zc.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.config.Configuration1;
import com.zc.entity.User;

import feign.Param;
import feign.RequestLine;

@FeignClient(name = "springcloud-eureka-provider", configuration = Configuration1.class)
public interface UserFeignClient {
	
	@RequestLine("GET /simple/{id}")
  public User findById(@Param("id") Long id); 
	
}