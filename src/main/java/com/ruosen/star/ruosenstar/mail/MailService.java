package com.ruosen.star.ruosenstar.mail;

import com.ruosen.star.ruosenstar.module.po.Mail;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     MailService   
 *  * @package    com.ruosen.star.ruosenstar.mail  
 *  * @author Administrator     
 *  * @date   2019/10/3 0003 星期四
 *  * @version V1.0.0
 *  
 */
public interface MailService {

    /**
     * 发送模板mail
     *
     * @param mail
     */
    void sendTemplateMail(Mail mail);

    /**
     * 发送简单的邮件
     *
     * @param mail
     */
    void sendSimpleMail(Mail mail);

    /**
     * 发送一个HTML格式的邮件
     *
     * @param mail
     */
    void sendHTMLMail(Mail mail);

    /**
     * 发送带附件格式的邮件
     *
     * @param mail
     */
    void sendAttachmentMail(Mail mail);

    /**
     * 发送带静态资源的邮件
     *
     * @param mail
     */
    void sendInlineMail(Mail mail);
}
