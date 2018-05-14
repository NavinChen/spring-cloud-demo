package com.springcloud.ribbonconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;
    
    @Autowired
    HelloService helloService;
    
    @GetMapping(value = {"/ribbon-consumer"})
    public String helloConsumer() {
        // return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
        // 增加Hystrix断路器
        return helloService.helloService();
    }

}
