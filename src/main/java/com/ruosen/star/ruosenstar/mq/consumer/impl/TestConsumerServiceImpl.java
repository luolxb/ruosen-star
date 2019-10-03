package com.ruosen.star.ruosenstar.mq.consumer.impl;

import com.rabbitmq.client.Channel;
import com.ruosen.star.ruosenstar.config.RabbitConfig;
import com.ruosen.star.ruosenstar.mq.consumer.TestConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     testConsumerImpl   
 *  * @package    com.ruosen.star.ruosenstar.mq.consumer.impl  
 *  * @author Administrator     
 *  * @date   2019/10/3 0003 星期四
 *  * @version V1.0.0
 *  
 */
@Slf4j
@Service
public class TestConsumerServiceImpl implements TestConsumerService {

    @Autowired
    private RabbitConfig rabbitConfig;

    /**
     * 监听消费
     *
     * @param channel
     * @param message
     */
    @Override
    @RabbitListener(queues = "${app.mq.registerQueue.bindingTopicExchangeReplyQueue.queueName}")
    @RabbitHandler
    public void testConsumer(Channel channel, Message message) {
        String body = new String(message.getBody());
        log.info("监听消费信息：{}", body);
    }
}
