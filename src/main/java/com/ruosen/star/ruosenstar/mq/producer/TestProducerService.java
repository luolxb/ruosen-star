package com.ruosen.star.ruosenstar.mq.producer;

import com.ruosen.star.ruosenstar.module.vo.SysUserVo;

/**
 *   测试生成
 *  * @projectName ruosen-star
 *  * @title     TestProducer   
 *  * @package    com.ruosen.star.ruosenstar.mq.producer  
 *  * @author Administrator     
 *  * @date   2019/10/3 0003 星期四
 *  * @version V1.0.0
 *  
 */
public interface TestProducerService {

    /**
     * 发送消息
     *
     * @param sysUserVo
     */
    void sendMsg(SysUserVo sysUserVo) throws Exception;
}
