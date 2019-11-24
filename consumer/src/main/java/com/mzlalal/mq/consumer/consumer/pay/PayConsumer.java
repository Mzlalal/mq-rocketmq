package com.mzlalal.mq.consumer.consumer.pay;

import com.mzlalal.mq.api.entity.dto.user.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * 模拟进行用户扣费并返回消息提示
 * @author: Mzlalal
 * @date: 2019/11/24 18:37
 * @version: 1.0
 */
@Slf4j
@Service
@RocketMQMessageListener(topic = "over-bus", consumerGroup = "pay")
public class PayConsumer implements RocketMQListener<UserDTO> {
    @Autowired
    RocketMQTemplate rocketMQTemplate;
    @Override
    public void onMessage(UserDTO message) {
        log.info("LogConsumer over-bus pay 收到信息开始扣费: {}", message);

        rocketMQTemplate.convertAndSend("pay-finish", String.format("用户:%s 支付完毕!", message.getUsername()));
    }
}
