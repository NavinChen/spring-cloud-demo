package com.springcloud.streamhello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Neo
 * @date 2018/7/5
 */
@EnableBinding({Sink.class, SinkSender.class})
public class SinkReceiver {
    
    private static Logger logger = LoggerFactory.getLogger(SinkReceiver.class);
    
    @StreamListener(Sink.INPUT)
    public void receive(Object payload) {
        logger.info("StreamListener Received:" + payload);
    }
    
    @ServiceActivator(inputChannel = Sink.INPUT + "2")
    public void receive2(Object payload) {
        logger.info("ServiceActivator Received:" + payload);
    }
    
    @Transformer(inputChannel = Sink.INPUT + "2", outputChannel = Sink.INPUT + "2")
    public Object transform(Date message) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(message);
    }
    
}
