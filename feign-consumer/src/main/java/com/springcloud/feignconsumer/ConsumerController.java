package com.springcloud.feignconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Neo
 * @date 2018/4/18
 */
@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;
    
    @Autowired
    RefactorHelloService refactorHelloService;
    
    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.hello();
    }
    
    @RequestMapping(value = "/feign-consumer2", method = RequestMethod.GET)
    public String helloConsumer2() {
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("\n");
        sb.append(helloService.hello("Neo")).append("\n");
        sb.append(helloService.hello("Neo", 30)).append("\n");
        sb.append(helloService.hello(new User("Neo", 30))).append("\n");
        return sb.toString();
    }
    
    @RequestMapping(value = "/feign-consumer3", method = RequestMethod.GET)
    public String helloConsumer3() {
        StringBuilder sb = new StringBuilder();
        sb.append(refactorHelloService.hello("Neo")).append("\n");
        sb.append(refactorHelloService.hello("Neo", 30)).append("\n");
        sb.append(refactorHelloService.hello(new com.springcloud.helloserviceapi.User("Neo", 30))).append("\n");
        return sb.toString();
    }

}
