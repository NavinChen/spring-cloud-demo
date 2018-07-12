package com.springcloud.streamapp2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

/**
 * @author Neo
 * @date 2018/7/12
 */
@EnableBinding(SinkOutput.class)
public class SinkSender {
    
    private static Logger logger = LoggerFactory.getLogger(SinkSender.class);
    
    @Bean
    @InboundChannelAdapter(value = "sinkOutput", poller = @Poller(fixedDelay = "2000"))
    public MessageSource<String> timerMessageSource() {
        return () -> new GenericMessage<>("{\"name\":\"didi\",\"age\":30}");
    }

}
