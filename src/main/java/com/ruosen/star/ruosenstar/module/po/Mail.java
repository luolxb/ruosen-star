package com.ruosen.star.ruosenstar.module.po;

import lombok.Data;

import java.io.Serializable;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     Mail   
 *  * @package    com.ruosen.star.ruosenstar.module.po  
 *  * @author Administrator     
 *  * @date   2019/10/3 0003 星期四
 *  * @version V1.0.0
 *  
 */
@Data
public class Mail implements Serializable {

    private static final long serialVersionUID = 7249525415840037674L;

    /**
     * 邮件接收人
     */
    private String recipient;
    /**
     * 邮件主题
     */
    private String subject;
    /**
     * 邮件内容
     */
    private String content;
}
