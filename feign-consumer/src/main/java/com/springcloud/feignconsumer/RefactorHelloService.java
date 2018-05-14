package com.springcloud.feignconsumer;

import com.springcloud.helloserviceapi.HelloService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author Neo
 * @date 2018/4/19
 */
@FeignClient(value = "HELLO-SERVICE")
public interface RefactorHelloService extends HelloService {

}
