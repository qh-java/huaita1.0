package com.huaita.springcloudorderserviceimpl.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TestConsumer {

    @JmsListener(destination = "queue1")
    public void receiveQueue(String text) {
        System.out.println(text);
    }

    @JmsListener(destination = "topic1")
    public void receiveTopic(String text) {
        System.out.println(text);
    }
}
