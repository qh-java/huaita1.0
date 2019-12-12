package com.huaita.springcloudorderserviceimpl.controller;

import com.alibaba.fastjson.JSON;
import com.huaita.springcloudapiorderservice.controller.OrderService;
import com.huaita.springcloudcommon.base.BaseApiService;
import com.huaita.springcloudorderserviceimpl.Feign.MemberFeign;
import com.huaita.springcloudorderserviceimpl.cache.CacheUtil;
import com.huaita.springcloudorderserviceimpl.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceImpl extends BaseApiService implements OrderService {

    public static Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired(required = false)
    private MemberFeign memberFeign;

    @Autowired
    private CacheUtil cacheUtil;


    @Override
    @RequestMapping("/getOrder")
    public ResponseBase orderToMember() {
        LOGGER.info("调用订单服务开始：{}",new Object[]{"getMemebr"});
        ResponseBase res = new ResponseBase();
        try {
            res = memberFeign.getMember();
            res.setResCode(0);
            res.setResMsg("获取会员数据成功");
            return res;
        } catch (Exception e) {
            res.setResCode(1);
            res.setResMsg("获取会员数据失败");
            LOGGER.error("调用失败",e);
        }
        return res;
    }

    @Override
    @RequestMapping("/getOrderInfo")
    public ResponseBase getOrderInfo() {
        ResponseBase res = new ResponseBase();
        Object str = cacheUtil.get("member_user");
        try{
        User user = JSON.parseObject(str+"", User.class);
        res.setResCode(0);
        res.setResMsg("获取用户信息成功！");
        res.setData(user);
        }catch(Exception ex){
            res.setResCode(1);
            res.setResMsg("获取用户信息失败");
            LOGGER.error("调用失败",ex);
       }
        return res;
    }

    @Override
    public ResponseBase queryOrderInfo() {
        return null;
    }


}
