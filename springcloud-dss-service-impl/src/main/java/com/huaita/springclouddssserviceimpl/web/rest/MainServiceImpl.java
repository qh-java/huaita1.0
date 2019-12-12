package com.huaita.springclouddssserviceimpl.web.rest;

import com.huaita.springcloudcommon.constant.HttpResponseBean;
import com.huaita.springcloudcommon.constant.ResultMenu;
import com.huaita.springclouddssserviceimpl.web.cache.CacheUtil;
import com.huaita.springclouddssserviceimpl.web.entity.SysUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("main")
@PropertySource("classpath:conf/set.properties")
public class MainServiceImpl {

    @Value("${sso.redis.key}")
    private String SSO_REDIS_KEY;

    @Value(value = "${sso.timeout}")
    private Integer SSO_TOKEN_TIMEOUT;

    @Value(value = "${cookie.key}")
    private String COOKIE_KEY;

//    @Value(value = "${system.ip.port}")
//    private String SYSTEM_IP_PORT;

    @Autowired
    private CacheUtil cacheUtil;

    @GetMapping("/test")
    public HttpResponseBean test(HttpServletRequest request, HttpServletResponse response) {
        HttpResponseBean hrb = new HttpResponseBean();
        hrb.setResMsg("nihao");
        return hrb;
    }

    @PostMapping("/main")
    public  HttpResponseBean toMain(HttpServletRequest request, HttpServletResponse response) {
        HttpResponseBean hrb = new HttpResponseBean();
        String systemCode = request.getParameter("systemCode");

        String token = request.getHeader(COOKIE_KEY);
        if (StringUtils.isBlank(token)) {
            hrb.setResCode(ResultMenu.NO_LOGIN.getCode());
            hrb.setResMsg(ResultMenu.NO_LOGIN.getMsg());
           // JsonHelper.bean2Json(response, hrb);
            return hrb;
        }
        SysUser user =  (SysUser)cacheUtil.get(SSO_REDIS_KEY+token);
        if(null == user){
            hrb.setResCode(ResultMenu.NO_LOGIN.getCode());
            hrb.setResMsg(ResultMenu.NO_LOGIN.getMsg());
            // JsonHelper.bean2Json(response, hrb);
            return hrb;
        }


        return hrb;
    }
}
