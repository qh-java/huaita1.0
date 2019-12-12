package com.huaita.springcloudorderserviceimpl.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("app-huaita-member")
public interface MemberFeign {

    @RequestMapping("/getMember")
    public ResponseBase getMember();

}
