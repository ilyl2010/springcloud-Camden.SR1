package com.zc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.zc.entity.User;
import com.zc.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EurekaClient eurekaClient;
	
	@GetMapping("/simple/{id}")
	public User findById(@PathVariable Long id) {
		return this.userRepository.findOne(id);
	}

	@GetMapping("/eureka-instance")
	  public String serviceUrl() {
	    InstanceInfo instance = this.eurekaClient.getNextServerFromEureka("SPRINGCLOUD-EUREKA-PROVIDER", false);
	    return instance.getHomePageUrl();
	  }
	
	 @Autowired
	  private DiscoveryClient discoveryClient;
	 @GetMapping("/instance-info")
	  public ServiceInstance showInfo() {
	    ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
	    return localServiceInstance;
	  }
	 
	 @PostMapping("/user")
	  public User postUser(@RequestBody User user) {
	    return user;
	  }

	  // 该请求不会成功
	  @GetMapping("/get-user")
	  public User getUser(User user) {
	    return user;
	  }
}
