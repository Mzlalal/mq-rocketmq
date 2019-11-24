package com.mzlalal.mq.producer.controller;

import com.mzlalal.mq.api.entity.Results;
import com.mzlalal.mq.api.entity.dto.user.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Mzlalal
 * @date: 2019/11/23 22:06
 * @version: 1.0
 */
@Slf4j
@RestController
@RequestMapping("test")
public class ProducerController {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @RequestMapping("testProducer")
    public Results testProducer(UserDTO dto) {
        rocketMQTemplate.asyncSend("topic-1", dto, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("成功");
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println("失败");
            }
        });
        return Results.OK("发送消息成功!");
    }

    @RequestMapping("test")
    public Results test() {
        return Results.OK("发送消息成功!");
    }
}
