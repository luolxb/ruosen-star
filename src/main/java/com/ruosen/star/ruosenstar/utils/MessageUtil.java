package com.ruosen.star.ruosenstar.utils;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;

import java.util.UUID;

/**
 *  设置rabbit消息请求头
 *  * @projectName ruosen-star
 *  * @title     MessageUtil   
 *  * @package    com.ruosen.star.ruosenstar.module.base  
 *  * @author Administrator     
 *  * @date   2019/10/3 0003 星期四
 *  * @version V1.0.0
 *  
 */
public class MessageUtil {

    /**
     * 设置rabbit消息请求头
     *
     * @param date
     * @return
     */
    public static Message transCoding(String date) {
        return MessageBuilder
                .withBody(date.getBytes())
                .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                .setContentEncoding("utf-8")
                .setMessageId(UUID.randomUUID() + "")
                .build();
    }
}
