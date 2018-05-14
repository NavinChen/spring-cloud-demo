package com.springcloud.feignconsumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author Neo
 * @date 2018/4/18
 */
// @FeignClient(value = "hello-service", fallback = HelloServiceFallback.class, configuration = DisableHystrixConfiguration.class)
@FeignClient(value = "hello-service", fallback = HelloServiceFallback.class)
public interface HelloService {
    
    @RequestMapping("/hello")
    String hello();
    
    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);
    
    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);
    
    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    String hello(@RequestBody User user);
    
}
