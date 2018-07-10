package com.springcloud.streamhello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamHelloApplicationTests {

    @Autowired
    private SinkSender sinkSender;
    
    @Autowired
    private MessageChannel input;
    
    @Autowired
    private SinkSender2 sinkSender2;
    
    @Test
    public void sinkSenderTest() {
        sinkSender.output().send(MessageBuilder.withPayload("From SinkSender").build());
    }
    
    @Test
    public void inputTest() {
        input.send(MessageBuilder.withPayload("From MessageChannel").build());
    }

}
