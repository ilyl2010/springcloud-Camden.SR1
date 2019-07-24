package com.zc.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.config.Configuration2;

@FeignClient(name = "xxx", url = "http://localhost:8761", configuration = Configuration2.class, fallback = FeignClientFallback2.class)
public interface FeignClient2 {
	@RequestMapping(value = "/eureka/apps/{serviceName}")
	public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);

}

@Component
class FeignClientFallback2 implements FeignClient2 {
	@Override
	public String findServiceInfoFromEurekaByServiceName(String serviceName) {
		return "xixi";
	}
}
