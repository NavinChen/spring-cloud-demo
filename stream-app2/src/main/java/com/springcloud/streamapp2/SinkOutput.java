package com.springcloud.streamapp2;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author Neo
 * @date 2018/7/12
 */
public interface SinkOutput {
    
    @Output("sinkOutput")
    MessageChannel output();
    
}
