package com.huaita.springcloudapimemberservice.dto;

import java.io.Serializable;

public class MemberInfoDTO implements Serializable {

    private String name;

    private String address;

    private String memInCardNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMemInCardNo() {
        return memInCardNo;
    }

    public void setMemInCardNo(String memInCardNo) {
        this.memInCardNo = memInCardNo;
    }
}
