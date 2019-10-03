package com.ruosen.star.ruosenstar.config;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Map;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     RabbitConfig   
 *  * @package    com.ruosen.star.ruosenstar.config  
 *  * @author Administrator     
 *  * @date   2019/10/3 0003 星期四
 *  * @version V1.0.0
 *  
 */
@Log4j2
@Data
@Configuration
@ConfigurationProperties(prefix = "app.mq")
public class RabbitConfig {

    /**
     * 测试发送mq routingkey
     */
    @Value("${app.mq.registerQueue.bindingTopicExchangePushQueue.routingKey}")
    public String testPushRoutingKey;
    /**
     * 测试发送mq 新增队列
     */
    @Value("${app.mq.registerQueue.bindingTopicExchangePushQueue.queueName}")
    public String testPushRoutingQueueName;
    /**
     * 测试监听mq routingkey
     */
    @Value("${app.mq.registerQueue.bindingTopicExchangeReplyQueue.routingKey}")
    public String testReplyRoutingKey;
    /**
     * 测试监听mq 新增队列
     */
    @Value("${app.mq.registerQueue.bindingTopicExchangeReplyQueue.queueName}")
    public String testReplyRoutingQueueName;
    @Value("${spring.rabbitmq.host}")
    private String host;
    @Value("${spring.rabbitmq.username}")
    private String username;
    @Value("${spring.rabbitmq.password}")
    private String password;
    @Value("${spring.rabbitmq.port}")
    private Integer port;
    @Value("${spring.rabbitmq.virtual-host}")
    private String virtualHost;
    @Value("${spring.rabbitmq.publisher-confirms}")
    private Boolean publisherConfirms;
    private String topicExchange;
    private Map<String, RabbitConfigField> registerQueue;

    @Autowired
    private GenericApplicationContext genericApplicationContext;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
        cachingConnectionFactory.setHost(host);
        cachingConnectionFactory.setUsername(username);
        cachingConnectionFactory.setPassword(password);
        cachingConnectionFactory.setPort(port);
        cachingConnectionFactory.setVirtualHost(virtualHost);
        // 如果需要进行消息回调，publisherConfirms 必须为true;
        cachingConnectionFactory.setPublisherConfirms(publisherConfirms);
        return cachingConnectionFactory;
    }


    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        return rabbitTemplate;
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(topicExchange);
    }

    /**
     * 自动创建队列，和绑定队列关系
     *
     * @return
     */
    @Bean
    public Object registerAutoQueue() {
        if (registerQueue != null) {
            registerQueue.forEach((bindingbBeanName, configField) -> {
                if (!configField.isQueueRegister()) {
                    genericApplicationContext.registerBean(configField.getQueueBeanName(), Queue.class, () ->
                            new Queue(configField.getQueueName(), true)
                    );
                }
                Queue queue = (Queue) genericApplicationContext.getBean(configField.getQueueBeanName());
                genericApplicationContext.registerBean(bindingbBeanName, Binding.class, () ->
                        BindingBuilder.bind(queue).to(topicExchange()).with(configField.getRoutingKey())
                );
            });
        }
        return new Object();
    }
}
