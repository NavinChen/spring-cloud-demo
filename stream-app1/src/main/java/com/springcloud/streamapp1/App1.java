package com.springcloud.streamapp1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.rxjava.EnableRxJavaProcessor;
import org.springframework.cloud.stream.annotation.rxjava.RxJavaProcessor;
import org.springframework.context.annotation.Bean;

import java.util.Date;

/**
 * @author Neo
 * @date 2018/7/10
 */
// @EnableBinding(value = Processor.class)
@EnableRxJavaProcessor
public class App1 {
    
    private static Logger logger = LoggerFactory.getLogger(App1.class);
    
    /*@StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Object receiveFromInput(Object payload) {
        logger.info("Received:" + payload);
        return "From Input Channel Return - " + payload;
    }*/
    
    /*@ServiceActivator(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
    public Object receiveFromInput(Object payload) {
        logger.info("Received:" + payload);
        return "From Input Channel Return - " + payload;
    }*/
    
    @Bean
    public RxJavaProcessor<Date, String> processor() {
        return inputStream -> inputStream.map(data -> {
            logger.info("Received:" + data);
            return data;
        }).buffer(5).map(data -> String.valueOf("From Input Channel Return - " + data));
    }
    
}
