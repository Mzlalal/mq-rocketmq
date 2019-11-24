package com.mzlalal.mq.producer.controller;

import com.mzlalal.mq.api.entity.Results;
import com.mzlalal.mq.api.entity.dto.user.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * 消息生产
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

    /**
     * 模拟上车
     * @param dto
     * @return
     */
    @RequestMapping("testProducer")
    public Results testProducer(UserDTO dto) {
        rocketMQTemplate.convertAndSend("over-bus", dto);
        return Results.OK("扫码成功!");
    }
}
