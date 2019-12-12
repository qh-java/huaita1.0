//package com.huaita.springcloudmemberserviceimpl.config;
//
//import org.apache.activemq.pool.PooledConnectionFactory;
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jms.connection.CachingConnectionFactory;
//import org.springframework.jms.core.JmsTemplate;
//
//@Configuration
//@AutoConfigureAfter(ActivemqConfig.class)
//public class ActivemqConfig {
//
//    @Bean
//    public JmsTemplate jmsTemplate(CachingConnectionFactory connectionFactory){
//        JmsTemplate jmsTemplate = new JmsTemplate();
//        jmsTemplate.setConnectionFactory(connectionFactory);
//        return jmsTemplate;
//    }
//
//}
