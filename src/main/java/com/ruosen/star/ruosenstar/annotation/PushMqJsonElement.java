package com.ruosen.star.ruosenstar.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  推送到mq的实体属性注解
 *  * @projectName ruosen-star
 *  * @title     PushMqJsonElement   
 *  * @package    com.ruosen.star.ruosenstar.annotation  
 *  * @author Administrator     
 *  * @date   2019/10/3 0003 星期四
 *  * @version V1.0.0
 *  
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface PushMqJsonElement {


    String value() default "";

    String dateFormat() default "yyyy/MM/dd";
}
