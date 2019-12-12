package com.huaita.springcloudmemberserviceimpl.controller;

import com.alibaba.fastjson.JSON;
import com.huaita.springcloudapimemberservice.controller.MemberService;
import com.huaita.springcloudapimemberservice.dto.MemberInfoDTO;
import com.huaita.springcloudcommon.base.BaseApiService;
import com.huaita.springcloudcommon.exception.BaseException;
import com.huaita.springcloudmemberserviceimpl.cache.CacheUtil;
import com.huaita.springcloudmemberserviceimpl.dao.UserMapper;
import com.huaita.springcloudmemberserviceimpl.pojo.User;
import com.huaita.springcloudmemberserviceimpl.producer.TestProduce;
import feign.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.jms.Topic;

@RestController
public class MemberServiceImpl extends BaseApiService implements  MemberService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired(required = false)
    private CacheUtil cacheUtil;

    @Autowired
    private TestProduce testProduce;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue1;

    @Autowired
    private Topic topic1;

    @RequestMapping("/getMember")
    @Override
    public ResponseBase getMember(){
        ResponseBase response = new ResponseBase();
        MemberInfoDTO dto = new MemberInfoDTO();
        User user = userMapper.queryUser("1");
        try {
            dto.setAddress("八卦洲");
            dto.setName(user.getName());
            dto.setMemInCardNo("22222222");
            response.setData(dto);
        } catch (Exception ex) {
            throw new BaseException("QueryMyYGOrderForPgDaoImpl.queryPgOrderInfo", ex);
        }
        return response;
    }

    @RequestMapping("/saveMember")
    @Override
    public  ResponseBase saveMember(@Param("name") String name) {
        ResponseBase response = new ResponseBase();
        User user = new User();
        user.setName(name);
        String str = JSON.toJSONString(user);
        cacheUtil.set("member_user",str,1000000);
        //此处需要将User扔到消息队列中
        testProduce.sendQueueMsg(user);  //此处是点对点
        testProduce.sendTopicMsg(user);   //此处是订阅与发布模式
        jmsMessagingTemplate.convertAndSend(queue1,"nihao wugui");
        jmsMessagingTemplate.convertAndSend(topic1,"nihao wanbadan");
        try{
            userMapper.saveUser(user);
            response.setResCode(0);
            response.setResMsg("保存成功");
        }catch(Exception ex){
            response.setResCode(0);
            response.setResMsg("保存成功");
            throw new BaseException("MemberServiceImpl.saveMember",ex);
        }
        return response;
    }

}
