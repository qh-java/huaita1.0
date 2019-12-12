package com.huaita.springclouddssserviceimpl;

import com.huaita.springclouddssserviceimpl.web.cache.CacheUtil;
import com.huaita.springclouddssserviceimpl.web.interceptor.LoginInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@MapperScan("com.huaita.springclouddssserviceimpl.web.dao")
@ComponentScan(basePackages = {"com.huaita.springclouddssserviceimpl.web"})
public class SpringcloudDssServiceImplApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudDssServiceImplApplication.class, args);
    }

//    @Bean
//    public LoginInterceptor loginInterceptor(){
//        return new LoginInterceptor();
//    }

    @Bean
    public CacheUtil cacheUtil(){
        CacheUtil cacheUtil = new CacheUtil();
        return cacheUtil;
    }
}
