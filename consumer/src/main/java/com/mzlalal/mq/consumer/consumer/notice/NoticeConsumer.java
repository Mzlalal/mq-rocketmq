package com.mzlalal.mq.consumer.consumer.notice;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @description:
 * 主题 消费分组在同样的情况下不会重复消费 而为负载均衡
 * @author: Mzlalal
 * @date: 2019/11/23 21:16
 * @version: 1.0
 */
@Slf4j
@Service
@RocketMQMessageListener(topic = "pay-finish", consumerGroup = "notice-user")
public class NoticeConsumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        log.info("NoticeConsumer pay-finish notice-user: {}", message);
    }
}
