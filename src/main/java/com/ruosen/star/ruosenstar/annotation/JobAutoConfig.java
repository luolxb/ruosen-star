package com.ruosen.star.ruosenstar.annotation;

import com.ruosen.star.ruosenstar.module.Enums.JobGroupEnum;
import org.quartz.Job;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     JobAutoConfig   
 *  * @package    com.ruosen.star.ruosenstar.annotation  
 *  * @author Administrator     
 *  * @date   2019/10/2 0002 星期三
 *  * @version V1.0.0
 *  
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface JobAutoConfig {

    /**
     * job 注册类
     *
     * @return
     */
    Class<? extends Job> claz();

    /**
     * job 名称
     *
     * @return
     */
    String jobName() default "";

    /**
     * job注入到spring容器中的名称
     *
     * @return
     */
    String jobBeanName() default "";

    /**
     * job 分组名称
     *
     * @return
     */
    JobGroupEnum jobGroupName() default JobGroupEnum.DUFAULT;

    /**
     * trigger 名称
     *
     * @return
     */
    String triggerName() default "";

    /**
     * trigger在spring容器中名称
     *
     * @return
     */
    String triggerBeanName() default "";


    /**
     * trigger 分组名称
     *
     * @return
     */
    JobGroupEnum triggerGroupName() default JobGroupEnum.DUFAULT;

    /**
     * cron 表达式
     *
     * @return
     */
    String cronSchedule() default "";

}