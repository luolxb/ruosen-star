package com.ruosen.star.ruosenstar.mail.impl;

import com.ruosen.star.ruosenstar.mail.MailService;
import com.ruosen.star.ruosenstar.module.po.Mail;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     MailServiceImpl   
 *  * @package    com.ruosen.star.ruosenstar.mail.impl  
 *  * @author Administrator     
 *  * @date   2019/10/3 0003 星期四
 *  * @version V1.0.0
 *  
 */
@Slf4j
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    private Configuration configuration;


    /**
     * 邮件发送者
     */
    @Value("${lance.mail.sender}")
    private String mailSender;

    /**
     * 发送模板email
     *
     * @param mail
     */
    @Override
    public void sendTemplateMail(Mail mail) {

        MimeMessage mimeMailMessage = null;
        try {
            mimeMailMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
            mimeMessageHelper.setFrom(mailSender);
            mimeMessageHelper.setTo(mail.getRecipient());
            mimeMessageHelper.setSubject(mail.getSubject());

            Map<String, Object> model = new HashMap<>();
            model.put("content", mail.getContent());
            model.put("title", "标题Mail中使用了FreeMarker");
            Template template = configuration.getTemplate("mail.html");
            String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            mimeMessageHelper.setText(text, true);

            javaMailSender.send(mimeMailMessage);

            log.info("发送模板邮件发送成功........");
        } catch (Exception e) {
            log.error("发送模板邮件发送失败", e);
        }
    }

    /**
     * 发送一个简单格式的邮件
     *
     * @param mail
     */
    @Override
    public void sendSimpleMail(Mail mail) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            //邮件发送人
            simpleMailMessage.setFrom(mailSender);
            //邮件接收人
            simpleMailMessage.setTo(mail.getRecipient());
            //邮件主题
            simpleMailMessage.setSubject(mail.getSubject());
            //邮件内容
            simpleMailMessage.setText(mail.getContent());
            javaMailSender.send(simpleMailMessage);
            log.info("发送一个简单格式的邮件成功....");
        } catch (Exception e) {
            log.error("发送一个简单格式的邮件失败", e);
        }
    }

    /**
     * 发送一个HTML格式的邮件
     *
     * @param mail
     */
    @Override
    public void sendHTMLMail(Mail mail) {
        MimeMessage mimeMailMessage = null;
        try {
            mimeMailMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
            mimeMessageHelper.setFrom(mailSender);
            mimeMessageHelper.setTo(mail.getRecipient());
            mimeMessageHelper.setSubject(mail.getSubject());
            StringBuilder sb = new StringBuilder();
            sb.append("<h1>SpirngBoot测试邮件HTML</h1>")
                    .append("<p style='color:#F00'>你是真的太棒了！</p>")
                    .append("<p style='text-align:right'>右对齐</p>");
            mimeMessageHelper.setText(sb.toString(), true);
            javaMailSender.send(mimeMailMessage);
            log.info("发送一个HTML格式的邮件成功......");
        } catch (Exception e) {
            log.error("发送一个HTML格式的邮件失败", e);
        }
    }

    /**
     * 发送带附件格式的邮件
     *
     * @param mail
     */
    @Override
    public void sendAttachmentMail(Mail mail) {
        MimeMessage mimeMailMessage = null;
        try {
            mimeMailMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
            mimeMessageHelper.setFrom(mailSender);
            mimeMessageHelper.setTo(mail.getRecipient());
            mimeMessageHelper.setSubject(mail.getSubject());
            mimeMessageHelper.setText(mail.getContent());
            //文件路径
            FileSystemResource file = new FileSystemResource(new File("src/main/resources/static/image/mail.png"));
            mimeMessageHelper.addAttachment("mail.png", file);

            javaMailSender.send(mimeMailMessage);
            log.info("发送带附件格式的邮件成功......");
        } catch (Exception e) {
            log.error("发送带附件格式的邮件失败", e);
        }
    }

    /**
     * 发送带静态资源的邮件
     *
     * @param mail
     */
    @Override
    public void sendInlineMail(Mail mail) {
        MimeMessage mimeMailMessage = null;
        try {
            mimeMailMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
            mimeMessageHelper.setFrom(mailSender);
            mimeMessageHelper.setTo(mail.getRecipient());
            mimeMessageHelper.setSubject(mail.getSubject());
            mimeMessageHelper.setText("<html><body>带静态资源的邮件内容，这个一张IDEA配置的照片:<img src='cid:picture' /></body></html>", true);
            //文件路径
            FileSystemResource file = new FileSystemResource(new File("src/main/resources/static/image/mail.png"));
            mimeMessageHelper.addInline("picture", file);

            javaMailSender.send(mimeMailMessage);
            log.info("发送带静态资源的邮件成功......");
        } catch (Exception e) {
            log.error("发送带静态资源的邮件失败", e);
        }
    }
}
