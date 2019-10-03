package com.ruosen.star.ruosenstar;

import com.ruosen.star.ruosenstar.mail.MailService;
import com.ruosen.star.ruosenstar.module.po.Mail;
import com.ruosen.star.ruosenstar.module.vo.SysUserVo;
import com.ruosen.star.ruosenstar.mq.producer.TestProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RuosenStarApplicationTests {

    @Autowired
    private TestProducerService testProducerService;

    @Autowired
    private MailService mailService;

    @Test
    public void contextLoads() {
        SysUserVo sysUserVo = new SysUserVo();
        sysUserVo.setAge(122);
        sysUserVo.setName("若森");
        sysUserVo.setNickName("ruosen");
        sysUserVo.setSex("男");
        try {
            testProducerService.sendMsg(sysUserVo);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testmail() {
        Mail mail = new Mail();
        mail.setContent("springboot-mail测试邮件");
        mail.setRecipient("1832209894@qq.com");
        mail.setSubject("这是一封测试邮件");
        mailService.sendTemplateMail(mail);
    }

    @Test
    public void sendSimpleMail() {
        Mail mail = new Mail();
        mail.setContent("sendSimpleMail");
        mail.setRecipient("1832209894@qq.com");
        mail.setSubject("这是一封测试sendSimpleMail邮件");
        mailService.sendSimpleMail(mail);
    }

    @Test
    public void sendHTMLMail() {
        Mail mail = new Mail();
        mail.setContent("sendHTMLMail");
        mail.setRecipient("809704354@qq.com");
        mail.setSubject("这是一封测试sendHTMLMail邮件");
        mailService.sendHTMLMail(mail);
    }

}
