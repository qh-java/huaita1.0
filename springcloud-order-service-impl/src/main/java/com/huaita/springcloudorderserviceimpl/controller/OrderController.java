package com.huaita.springcloudorderserviceimpl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("getOrder1")
    public String getOrder() {
        String memberUrl = "http://app-huaita-member/getMember";
        return restTemplate.getForObject(memberUrl, String.class);
    }
}
