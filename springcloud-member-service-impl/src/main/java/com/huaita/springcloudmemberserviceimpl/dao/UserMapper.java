package com.huaita.springcloudmemberserviceimpl.dao;


import com.huaita.springcloudmemberserviceimpl.pojo.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {

    public User queryUser(@Param("id")String id);

    public void saveUser(User user);

}
