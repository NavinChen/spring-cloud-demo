package com.springcloud.streamapp2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;

/**
 * @author Neo
 * @date 2018/7/10
 */
@EnableBinding(value = Processor.class)
public class App2 {
    
    private static Logger logger = LoggerFactory.getLogger(App2.class);
    
    /*@Bean
    @InboundChannelAdapter(value = Processor.OUTPUT, poller = @Poller(fixedDelay = "2000"))
    public MessageSource<Date> timerMessageSource() {
        return () -> new GenericMessage<>(new Date());
    }*/
    
    @StreamListener(Processor.INPUT)
    public void receiveFromOutput(Object payload) {
        logger.info("Received:" + payload);
    }
    
}
