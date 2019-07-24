package com.zc.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

import com.config.Configuration1;
import com.zc.entity.User;

import feign.Param;
import feign.RequestLine;

@FeignClient(name = "springcloud-eureka-provider", configuration = Configuration1.class,fallback=FeignClientFallback.class)
public interface UserFeignClient {
	
	@RequestLine("GET /simple/{id}")
  public User findById(@Param("id") Long id); 
	
}

/**
* 回退类FeignClientFallback需实现Feign Client接口
* FeignClientFallback也可以是public class，没有区别
*/
@Component
class FeignClientFallback implements UserFeignClient {
  @Override
  public User findById(Long id) {
    User user = new User();
    user.setId(-1L);
    user.setUsername("默认用户");
    return user;
  }
}