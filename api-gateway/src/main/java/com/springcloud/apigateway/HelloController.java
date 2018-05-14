package com.springcloud.apigateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Neo
 * @date 2018/5/3
 */
@RestController
public class HelloController {
    
    @RequestMapping("/local/hello")
    public String hello() {
        return "Hello World Local";
    }
    
}
