package com.ruosen.star.ruosenstar.config;

import lombok.Data;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     RabbitConfigField   
 *  * @package    com.ruosen.star.ruosenstar.config  
 *  * @author Administrator     
 *  * @date   2019/10/3 0003 星期四
 *  * @version V1.0.0
 *  
 */
@Data
public class RabbitConfigField {

    /**
     * 队列名称
     */
    private String queueName;

    /**
     * 路由键
     */
    private String routingKey;

    /**
     * 队列注入到spring容器中的名称
     */
    private String queueBeanName;

    /**
     * 队列是否已经注册
     */
    private boolean queueRegister;
}
