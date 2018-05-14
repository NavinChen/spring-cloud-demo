package com.springcloud.helloserviceapi;

import org.springframework.web.bind.annotation.*;

/**
 * @author Neo
 * @date 2018/4/19
 */
@RequestMapping("/refactor")
public interface HelloService {
    
    @RequestMapping(value = "/hello4", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);
    
    @RequestMapping(value = "/hello5", method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);
    
    @RequestMapping(value = "/hello6", method = RequestMethod.POST)
    String hello(@RequestBody User user);
    
}
