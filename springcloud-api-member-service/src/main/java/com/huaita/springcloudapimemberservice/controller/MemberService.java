package com.huaita.springcloudapimemberservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public interface MemberService {

    @RequestMapping("/getMember")
    public ResponseBase getMember();

    @RequestMapping("/saveMember")
    public ResponseBase saveMember(String name);
}
