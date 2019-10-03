package com.ruosen.star.ruosenstar.mq.producer.impl;

import com.ruosen.star.ruosenstar.config.RabbitConfig;
import com.ruosen.star.ruosenstar.module.base.MessageUtil;
import com.ruosen.star.ruosenstar.module.base.ModelToMq;
import com.ruosen.star.ruosenstar.module.vo.SysUserVo;
import com.ruosen.star.ruosenstar.mq.producer.TestProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *   发送消息实体类
 *  * @projectName ruosen-star
 *  * @title     TestProducerServiceImpl   
 *  * @package    com.ruosen.star.ruosenstar.mq.producer.impl  
 *  * @author Administrator     
 *  * @date   2019/10/3 0003 星期四
 *  * @version V1.0.0
 *  
 */
@Slf4j
@Service
public class TestProducerServiceImpl implements TestProducerService {

    @Autowired
    private RabbitConfig rabbitConfig;

    @Autowired
    private AmqpTemplate rabbitTemlate;

    @Override
    public void sendMsg(SysUserVo sysUserVo) throws Exception {
        ModelToMq modelToMq = new ModelToMq();
        String jsonToString = modelToMq.getJsonToString(sysUserVo, null);
        log.info("发送测试信息：{}", jsonToString);

        senderMessage(jsonToString, "1213");
    }

    private void senderMessage(String body, String code) {
        Message message = MessageUtil.transCoding(body);
        rabbitTemlate.convertAndSend(rabbitConfig.getTopicExchange(), rabbitConfig.getTestPushRoutingKey(), message);
        // TODO 将消息新增rabbit表中
    }
}
