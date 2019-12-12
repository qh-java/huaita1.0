package com.huaita.springcloudgatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class SpringcloudGatewayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudGatewayServerApplication.class, args);
    }

}
