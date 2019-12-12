package com.huaita.springcloudmemberserviceimpl.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
@EnableJms
@PropertySource("classpath:mq/mq.properties")
public class JmsConfig {

    @Value("application.topicDestinationName1")
    public String topic1;

    @Value("application.topicDestinationName2")
    public String topic2;

    @Value("application.queueDestinationName1")
    public String queue1;

    @Value("application.queueDestinationName2")
    public String queue2;

    @Bean
    public Topic topic1(){
       return new ActiveMQTopic(topic1);
    }

    @Bean
    public Topic topic2(){
        return new ActiveMQTopic(topic2);
    }

    @Bean
    public Queue queue1() {
        return new ActiveMQQueue(queue1);
    }

    @Bean
    public Queue queue2() {
        return new ActiveMQQueue(queue2);
    }
}
