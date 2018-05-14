package com.springcloud.rabbitmqhello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

// @RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqHelloApplicationTests {
    
    @Autowired
    private Sender sender;

    @Test
    public void contextLoads() {
    }
    
    @Test
    public void hello() throws Exception{
        sender.send();
    }

}
