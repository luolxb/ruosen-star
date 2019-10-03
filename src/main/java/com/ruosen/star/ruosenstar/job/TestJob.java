package com.ruosen.star.ruosenstar.job;

import com.ruosen.star.ruosenstar.annotation.JobAutoConfig;
import com.ruosen.star.ruosenstar.module.Enums.JobGroupEnum;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     TestJob   
 *  * @package    com.ruosen.star.ruosenstar.job  
 *  * @author Administrator     
 *  * @date   2019/10/3 0003 星期四
 *  * @version V1.0.0
 *  
 * jobBeanName 名称不要与job类名称一致
 *
 */
@Slf4j
@Component
@DisallowConcurrentExecution
@JobAutoConfig(
        claz = TestJob.class,
        jobBeanName = "testJobTest",
        jobGroupName = JobGroupEnum.RUOSEN_STAR,
        triggerGroupName = JobGroupEnum.RUOSEN_STAR,
        cronSchedule = "*/10 * * * * ?"
)
public class TestJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("TestJob  start......{}", jobExecutionContext);
    }
}
