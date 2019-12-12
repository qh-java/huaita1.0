package com.huaita.springcloudssoserver.ds.mapper;

import com.huaita.springcloudssoserver.ds.entity.AddressUsers;
import com.huaita.springcloudssoserver.ds.entity.SysUser;
import org.springframework.data.repository.query.Param;

public interface SysUserMapper {

     SysUser querySysUser(@Param("userCode") String userCode, @Param("userPassword")  String userPassword );

     AddressUsers queryAddressBookUserByUserId(@Param("userId") String userId);
}
