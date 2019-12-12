package com.huaita.springcloudmemberserviceimpl.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;

/**
 *
 * 生产者的基本类
 */
public class BaseProduce<T> {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMsg(Destination den, T t) {
        jmsTemplate.convertAndSend(den, t);
    }
}
