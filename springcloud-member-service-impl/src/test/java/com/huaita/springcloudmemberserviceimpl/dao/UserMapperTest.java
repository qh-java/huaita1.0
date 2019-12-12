package com.huaita.springcloudmemberserviceimpl.dao;

import com.huaita.springcloudmemberserviceimpl.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * dao层测试用例
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testGetUser(){
        User user = userMapper.queryUser("3");
        System.out.print(user.getName());
    }
}
