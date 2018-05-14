package com.springcloud.feignconsumer;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * @author Neo
 * @date 2018/4/19
 */
public class DisableHystrixConfiguration {
    
    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }
    
}
