package com.ruosen.star.ruosenstar.service;

import com.ruosen.star.ruosenstar.module.vo.SmsValidRq;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     SendSmsService   
 *  * @package    com.ruosen.star.ruosenstar.service  
 *  * @author Administrator     
 *  * @date   2019/11/17 0017 星期日
 *  * @version V1.0.0
 *  
 */
public interface SendSmsService {

    String sendPhoneCode(String mobile);

    void valid(SmsValidRq smsValidRq);
}
