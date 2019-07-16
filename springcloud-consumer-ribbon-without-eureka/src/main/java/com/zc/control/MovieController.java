package com.zc.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zc.entity.User;

@RestController
public class MovieController {
  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private LoadBalancerClient loadBalancerClient;
  
  @GetMapping("/movie/{id}")
  public User findById(@PathVariable Long id) {
	  ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
	    System.out.println("===" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());

	      return this.restTemplate.getForObject("http://springcloud-eureka-provider1/simple/"+ id, User.class);
  }
  
  @GetMapping("/test")
  public String test() {
    ServiceInstance serviceInstance = this.loadBalancerClient.choose("springcloud-eureka-provider");
    System.out.println("111" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());
    ServiceInstance serviceInstance1 = this.loadBalancerClient.choose("springcloud-eureka-provider1");
    System.out.println("222" + ":" + serviceInstance1.getServiceId() + ":" + serviceInstance1.getHost() + ":" + serviceInstance1.getPort());

    return "1";
  }
}