package com.huaita.springcloudssoserver;

import com.huaita.springcloudssoserver.ds.cache.CacheUtil;
import com.huaita.springcloudssoserver.ds.sql.SqlCacheHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.huaita.springcloudssoserver.ds.mapper")
public class SpringcloudSsoServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudSsoServerApplication.class, args);
    }


    @Bean
    public CacheUtil cacheUtil(){
        CacheUtil cacheUtil = new CacheUtil();
        return cacheUtil;
    }

    @Bean
    public SqlCacheHelper sqlCacheHelper(){
        SqlCacheHelper sqlCacheHelper =  new SqlCacheHelper();
        return sqlCacheHelper;
    }
}
