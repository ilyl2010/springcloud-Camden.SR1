package com.zc.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zc.entity.User;

@FeignClient(name = "springcloud-eureka-provider", /*fallback = FeignClientFallback.class, */fallbackFactory = UserFeignClientHystrixFallbackFactory.class)
public interface UserFeignClient {
	@RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable("id") Long id); // 两个坑：1. @GetMapping不支持 2. @PathVariable得设置value
}

@Component
class FeignClientFallback implements UserFeignClient {
	
	@Override
	public User findById(Long id) {
		User user = new User();
		user.setId(0L);
		user.setUsername("默认用户");
		return user;
	}
}