package com.huaita.springcloudssoserver.ds.controller;

import com.alibaba.fastjson.JSON;
import com.huaita.springcloudssoserver.ds.cache.CacheUtil;
import com.huaita.springcloudssoserver.ds.constants.HttpResponseBean;
import com.huaita.springcloudssoserver.ds.constants.ResultMenu;
import com.huaita.springcloudssoserver.ds.entity.AddressUsers;
import com.huaita.springcloudssoserver.ds.entity.SysUser;
import com.huaita.springcloudssoserver.ds.service.SysUserService;
import com.huaita.springcloudssoserver.ds.util.IDUtil;
import com.huaita.springcloudssoserver.ds.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@PropertySource("classpath:conf/set.properties")
public class LoginController {

    static List<String> list = new ArrayList<String>();

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private CacheUtil cacheUtil;

    @Value("${sso.redis.key}")
    private String SSO_REDIS_KEY;

    @Value(value = "${sso.timeout}")
    private Integer SSO_TOKEN_TIMEOUT;

    @Value(value = "${cookie.key}")
    private String COOKIE_KEY;

    @RequestMapping("/login")
    @ResponseBody
    public HttpResponseBean login(String userCode, String userPassword, HttpServletRequest request, HttpServletResponse response) {
        HttpResponseBean hrb = new HttpResponseBean();
        SysUser user = null;
        try {
         //   user = this.sysUserService.login(userCode, userPassword);
           user = new SysUser();
           user.setUserCode("222222222");
           user.setUserCode("1111");
           user.setUserName("张阳");
            userCode = user.getUserCode();
            if (null == user) {
                hrb.setResCode(ResultMenu.LOGIN_PARAM_ERROR.getCode());
                hrb.setResMsg(ResultMenu.LOGIN_PARAM_ERROR.getMsg());
                return hrb;
            }
            // 用户冻结状态逻辑
            if ("freeze".equals(user.getUserState())) {
                hrb.setResCode(ResultMenu.LOGIN_FREEZE_ERROR.getCode());
                hrb.setResMsg(ResultMenu.LOGIN_FREEZE_ERROR.getMsg());
                return hrb;
            }

            String token = JwtUtil.geneJsonWebToken(user);

            //String token = IDUtil.getUUIDStr();
            AddressUsers addressUsers = sysUserService.queryAddressBookUserByUserId(userCode);
            if (null != addressUsers) {
                //这段代码让我费解为什么是主键进入
                user.setAddressUserId(addressUsers.getId());
            }
            cacheUtil.set(SSO_REDIS_KEY + token, user);

            //将token存入前端的cookie
            Cookie cookie = new Cookie("Authorization", token);
            list.add(token);
            response.addCookie(cookie);
            hrb.setResCode(ResultMenu.SUCCESS_CODE.getCode());
            hrb.setResMsg(ResultMenu.SUCCESS_CODE.getMsg());
        } catch (Exception e) {
            hrb.setResCode(ResultMenu.LOGIN_PARAM_ERROR.getCode());
            hrb.setResMsg(ResultMenu.LOGIN_PARAM_ERROR.getMsg());
            e.printStackTrace();
            return hrb;
        }
        return hrb;

    }

    @RequestMapping(value = "/checkToken")
    @ResponseBody
    public String checkToken(String token) {
        String key = SSO_REDIS_KEY + token;
        if (list.contains(token) && cacheUtil.get(key) != null) {
            return "correct";
        }
        return "incorrect";
    }

    @RequestMapping("/loginin")
    public String test() {
        return "login.html";
    }

}
