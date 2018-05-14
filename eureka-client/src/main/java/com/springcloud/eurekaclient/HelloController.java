package com.springcloud.eurekaclient;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient discoveryClient;
    
    @GetMapping(value = {"/hello"})
    public String index() throws Exception {
        ServiceInstance localServiceInstance = discoveryClient.getLocalServiceInstance();
        logger.info("/hello ,host:" + localServiceInstance.getHost() +", service_id:" + localServiceInstance.getServiceId());
    
        List<String> services = discoveryClient.getServices();
        logger.info("services:" + services);
    
        // 由于Hystrix默认超时时间为1000毫秒，所以这里采用0至3000的随机数以让处理过程有一定概率发生超时来触发断路器
        // 让处理线程等待几秒钟
        // int sleepTime = new Random().nextInt(3000);
        int sleepTime = 500;
        logger.info("sleepTime:" + sleepTime);
        Thread.sleep(sleepTime);
    
        return "Hello world";
    }
    
    @GetMapping(value = {"/hello1"})
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }
    
    @GetMapping(value = {"/hello2"})
    public User hello(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name, age);
    }
    
    @PostMapping(value = {"/hello3"})
    public String hello(@RequestBody User user) {
        return "Hello " + user.getName() + ", " + user.getAge();
    }
    
}
