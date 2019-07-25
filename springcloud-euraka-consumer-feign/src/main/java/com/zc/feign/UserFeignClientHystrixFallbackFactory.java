package com.zc.feign;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.zc.entity.User;


import feign.hystrix.FallbackFactory;

@Component
public class UserFeignClientHystrixFallbackFactory  implements FallbackFactory<UserFeignClient>{
	
	private static final Logger LOGGER=LoggerFactory.getLogger(UserFeignClientHystrixFallbackFactory.class);
	
	@Override
	public UserFeignClient create(Throwable cause) {
		LOGGER.info("fallback; reason was: {}", cause.getMessage());
		// TODO Auto-generated method stub
		return  new UserFeignClientWithFactory() {
		      @Override
		      public User findById(Long id) {
		        User user = new User();
		        user.setId(-1L);
		        return user;
		      }
		    };}

}
