package com.mzlalal.mq.consumer.consumer;

import com.mzlalal.mq.api.entity.dto.user.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

import static org.apache.rocketmq.spring.annotation.MessageModel.BROADCASTING;

/**
 * @description:
 * 主题 消费分组在同样的情况下不会重复消费 默认而为负载均衡
 * 设置messagemodel后 为广播模式 任何一条主题消息都会获取
 * @author: Mzlalal
 * @date: 2019/11/23 21:16
 * @version: 1.0
 */
@Slf4j
@Service
@RocketMQMessageListener(topic = "over-bus", consumerGroup = "user-information", messageModel = BROADCASTING)
public class UserConsumer2 implements RocketMQListener<UserDTO> {
    @Override
    public void onMessage(UserDTO message) {
        log.info("UserConsumer2 over-bus user-information 收到用户信息: {}", message);
    }
}
