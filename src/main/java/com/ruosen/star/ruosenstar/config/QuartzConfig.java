package com.ruosen.star.ruosenstar.config;

import com.ruosen.star.ruosenstar.annotation.JobAutoConfig;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Map;

/**
 *   自动注册quartz
 *  * @projectName ruosen-star
 *  * @title     QuartzConfig   
 *  * @package    com.ruosen.star.ruosenstar.config  
 *  * @author Administrator     
 *  * @date   2019/10/2 0002 星期三
 *  * @version V1.0.0
 *  
 */
//@Configuration
public class QuartzConfig {

    @Autowired
    private GenericApplicationContext genericApplicationContext;

    @Bean
    public Object registerBean() {
        Map<String, Object> beansWithAnnotation = genericApplicationContext.getBeansWithAnnotation(JobAutoConfig.class);
        beansWithAnnotation.forEach((k, v) -> {
            Class<?> clz = v.getClass();
            JobAutoConfig annotation = clz.getAnnotation(JobAutoConfig.class);
            String jobName = annotation.jobName().isEmpty() ? k : annotation.jobName();
            String jobBeanName = annotation.jobBeanName().isEmpty() ? k : annotation.jobBeanName();
            String triggerName = annotation.triggerName().isEmpty() ? k + "Trigger" : annotation.triggerName();
            String triggerBeanName = annotation.triggerBeanName().isEmpty() ? k + "Trigger" : annotation.triggerBeanName();

            genericApplicationContext.registerBean(jobBeanName, JobDetail.class, () ->
                    JobBuilder.newJob(annotation.claz())
                            .withIdentity(jobName, annotation.jobGroupName().name())
                            .storeDurably()
                            .build()
            );
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(annotation.cronSchedule());
            genericApplicationContext.registerBean(triggerBeanName, Trigger.class, () ->
                    TriggerBuilder.newTrigger()
                            .forJob(jobName, annotation.jobGroupName().name())
                            .withIdentity(triggerName, annotation.triggerGroupName().name())
                            .withSchedule(scheduleBuilder).build()
            );
        });
        return new Object();
    }
}
