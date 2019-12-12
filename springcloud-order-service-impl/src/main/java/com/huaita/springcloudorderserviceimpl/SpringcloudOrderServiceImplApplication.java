package com.huaita.springcloudorderserviceimpl;

import com.huaita.springcloudorderserviceimpl.cache.CacheUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SpringcloudOrderServiceImplApplication {

    @Bean
    public RestTemplate restTemplate(){
       return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudOrderServiceImplApplication.class, args);
    }
    @Bean
    public CacheUtil cacheUtil(){
        CacheUtil cacheUtil = new CacheUtil();
        RedisTemplate redisTemplate = new RedisTemplate();
        cacheUtil.setRedisTemplate(redisTemplate);
        return cacheUtil;
    }
}
