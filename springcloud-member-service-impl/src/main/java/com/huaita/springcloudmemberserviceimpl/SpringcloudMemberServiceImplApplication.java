package com.huaita.springcloudmemberserviceimpl;

import com.huaita.springcloudmemberserviceimpl.cache.CacheUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Queue;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@MapperScan("com.huaita.springcloudmemberserviceimpl.dao")
public class SpringcloudMemberServiceImplApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudMemberServiceImplApplication.class, args);
    }

    @Bean
    public CacheUtil cacheUtil(){
        CacheUtil cacheUtil = new CacheUtil();
//        RedisTemplate redisTemplate = new RedisTemplate();
//        cacheUtil.setRedisTemplate(redisTemplate);
        return cacheUtil;
    }

}
