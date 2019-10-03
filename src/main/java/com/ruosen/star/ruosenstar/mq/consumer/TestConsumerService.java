package com.ruosen.star.ruosenstar.mq.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;


/**
 *   测试消费
 *  * @projectName ruosen-star
 *  * @title     testConsumer   
 *  * @package    com.ruosen.star.ruosenstar.mq.producer.consumer  
 *  * @author Administrator     
 *  * @date   2019/10/3 0003 星期四
 *  * @version V1.0.0
 *  
 */
public interface TestConsumerService {

    void testConsumer(Channel channel, Message message);
}
