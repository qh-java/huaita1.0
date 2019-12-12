package com.huaita.springclouddssserviceimpl.web.config;

import com.huaita.springclouddssserviceimpl.web.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 这个打jar的时候不需要
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
     @Autowired
    private LoginInterceptor loginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 拦截器按照顺序执行
         */

        List<String> notLoginInterceptPaths = new ArrayList<String>();

        List<String> pathPatterns = new ArrayList<String>();
        pathPatterns.add("/main/**");
        registry.addInterceptor(loginInterceptor).addPathPatterns(pathPatterns);
        super.addInterceptors(registry);
    }



}