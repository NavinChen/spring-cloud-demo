package com.springcloud.streamapp1;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

/**
 * @author Neo
 * @date 2018/7/12
 */
public interface SinkInput {
    
    @Input("sinkInput")
    MessageChannel inputput();
    
}
