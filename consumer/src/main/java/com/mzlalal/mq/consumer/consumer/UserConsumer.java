package com.mzlalal.mq.consumer.consumer;

import com.mzlalal.mq.api.entity.dto.user.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Mzlalal
 * @date: 2019/11/23 21:16
 * @version: 1.0
 */
@Slf4j
@Service
@RocketMQMessageListener(topic = "topic-1", consumerGroup = "group-1")
public class UserConsumer implements RocketMQListener<UserDTO> {
    @Override
    public void onMessage(UserDTO dto) {
        log.info("consumer-one received message: {}", dto);
    }
}
