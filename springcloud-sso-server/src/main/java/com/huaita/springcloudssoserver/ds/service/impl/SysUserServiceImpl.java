package com.huaita.springcloudssoserver.ds.service.impl;

import com.huaita.springcloudssoserver.ds.entity.AddressUsers;
import com.huaita.springcloudssoserver.ds.entity.SysUser;
import com.huaita.springcloudssoserver.ds.mapper.SysUserMapper;
import com.huaita.springcloudssoserver.ds.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired(required = false)
    SysUserMapper sysUserMapper;
    @Override
    public SysUser login(String userCode, String userPassword) {
        return sysUserMapper.querySysUser(userCode,userPassword);
    }

    @Override
    public AddressUsers queryAddressBookUserByUserId(String userId) {
        return sysUserMapper.queryAddressBookUserByUserId(userId);
    }
}
