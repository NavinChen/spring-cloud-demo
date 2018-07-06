package com.springcloud.streamhello;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;

/**
 * @author Neo
 * @date 2018/7/6
 */
public interface SinkSender {
    
    @Output(Sink.INPUT)
    MessageChannel output();
    
}
