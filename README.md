rocketmq简单集成
<br/>
### 目录结构
1. API 为公共实体以及服务
2. PRODUCER 为生产者
3. CONSUMER 为消费者
### 发送消息
配置rocketmq nameserver地址
``` java
# 生产者分组
rocketmq.producer.group=mzlalal-mq
# rocket name server服务器地址
rocketmq.name-server=127.0.0.1:9876

// 使用RocketMQTemplate进行消息发送

// 注入
@Autowired
private RocketMQTemplate rocketMQTemplate;

// 发送消息
rocketMQTemplate.convertAndSend("topic", yourObject);
```
### 接收消息
在类上使用注解@RocketMQMessageListener
<br/>
最简单的使用如下：指定属性topic consumerGroup
<br/>@RocketMQMessageListener(topic = "over-bus", consumerGroup = "user-information")
<br/>consumerGroup 主要作用为根据消费模式 messageModel 进行不同的操作
<br/>messageModel 分为广播和集群
- 广播为所有的consumerGroup都进行消费
- 集群类似为负载均衡选取其中一个进行消费