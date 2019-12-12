package com.huaita.springcloudapiorderservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public interface OrderService {

    @RequestMapping("/getOrder")
    public ResponseBase orderToMember();

    @RequestMapping("/getOrderInfo")
    public ResponseBase getOrderInfo();

    @RequestMapping("queryOrderInfo")
    public ResponseBase queryOrderInfo();
}
