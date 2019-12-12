package com.huaita.springcloudssoserver.ds.service;

import com.huaita.springcloudssoserver.ds.entity.AddressUsers;
import com.huaita.springcloudssoserver.ds.entity.SysUser;
import org.springframework.stereotype.Service;

@Service
public interface SysUserService {

    SysUser login(String userCode, String userPassword);

    AddressUsers queryAddressBookUserByUserId(String userId);
}
