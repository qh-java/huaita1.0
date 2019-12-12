package com.huaita.springclouddssserviceimpl.web.interceptor;

import com.huaita.springcloudcommon.constant.HttpResponseBean;
import com.huaita.springcloudcommon.util.HttpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
@Component
@PropertySource("classpath:conf/set.properties")
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Value("${sso.authCheck}")
    private String authCheck;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpResponseBean hrb = new HttpResponseBean();
       String token  = request.getHeader("Authorization");
       /*******测试之用*****************************/
       Cookie[] cookies = request.getCookies();
        if(null != cookies){
            for(Cookie cookie : cookies){
                if("Authorization".equals(cookie.getName())){
                    token = cookie.getValue();
                }
            }
        }
        /*******************************************/
       if(null != token){
           //到sso的服务端请求是否准确
           Map<String, String> map = new HashMap<String, String>();
           map.put("token",token);
           String result = HttpUtil.sendPost(authCheck,map);
           if("correct".equals(result)){
             return true;
           }
       }
//        String url = request.getRequestURI();
//        hrb.setData(url);
//        hrb.setResCode(ResultMenu.NO_LOGIN.getCode());
//        hrb.setResMsg(ResultMenu.NO_LOGIN.getMsg());
//        JsonHelper.bean2Json(response, hrb);
        //测试之用
        response.sendRedirect("http://127.0.0.1:8098/loginin");
        return false;
    }
}
