package com.mzlalal.mq.consumer.consumer.log;

import com.mzlalal.mq.api.entity.dto.user.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @description:
 * 记录用户行程日志
 * @author: Mzlalal
 * @date: 2019/11/24 18:37
 * @version: 1.0
 */
@Slf4j
@Service
@RocketMQMessageListener(topic = "over-bus", consumerGroup = "log")
public class LogConsumer implements RocketMQListener<UserDTO> {
    @Override
    public void onMessage(UserDTO message) {
        log.info("LogConsumer over-bus log 收到信息开始记录日志: {}", message);
    }
}
