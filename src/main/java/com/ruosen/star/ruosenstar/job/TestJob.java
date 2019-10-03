package com.ruosen.star.ruosenstar.job;

import com.ruosen.star.ruosenstar.annotation.JobAutoConfig;
import com.ruosen.star.ruosenstar.module.Enums.JobGroupEnum;
import lombok.extern.log4j.Log4j2;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     TestJob   
 *  * @package    com.ruosen.star.ruosenstar.job  
 *  * @author Administrator     
 *  * @date   2019/10/3 0003 星期四
 *  * @version V1.0.0
 *  
 */
@JobAutoConfig(claz = TestJob.class,
        jobBeanName = "testJob",
        jobGroupName = JobGroupEnum.RUOSEN_STAR,
        triggerGroupName = JobGroupEnum.RUOSEN_STAR,
        cronSchedule = "0 1 * * * ?")
@Log4j2
public class TestJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("TestJob  start......");
    }
}
