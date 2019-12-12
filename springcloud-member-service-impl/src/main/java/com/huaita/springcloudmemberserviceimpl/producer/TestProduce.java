package com.huaita.springcloudmemberserviceimpl.producer;

import com.huaita.springcloudmemberserviceimpl.base.BaseProduce;
import com.huaita.springcloudmemberserviceimpl.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;

@Component
public class TestProduce extends BaseProduce<User> {

    @Autowired
    private Topic topic1;

    @Autowired
    private Queue queue1;
    //
    public void sendTopicMsg(User user){
        //当然这里把对象扔到topic之前做一些业务逻辑 其中泛型也可以自定义  不一定非要User
        super.sendMsg(topic1,user);
    }

    public void sendQueueMsg(User user){
        //当然这里把对象扔到topic之前做一些业务逻辑 其中泛型也可以自定义  不一定非要User
        super.sendMsg(queue1,user);
    }
}

