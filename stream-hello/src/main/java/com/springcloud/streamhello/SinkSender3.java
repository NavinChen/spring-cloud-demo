package com.springcloud.streamhello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

import java.util.Date;

/**
 * @author Neo
 * @date 2018/7/10
 */
@EnableBinding({SinkSender3.SinkOutput.class})
public class SinkSender3 {
    
    private static Logger logger = LoggerFactory.getLogger(SinkSender3.class);
    
    public interface SinkOutput {
        String OUTPUT = "user2";
        
        @Output(SinkOutput.OUTPUT)
        MessageChannel output();
    }
    
    @Bean
    @InboundChannelAdapter(value = "user2", poller = @Poller(fixedDelay = "2000"))
    public MessageSource<String> userMessageSource() {
        return () -> new GenericMessage<>("{\"name\":\"didi\",\"age\":30}");
    }
    
}
