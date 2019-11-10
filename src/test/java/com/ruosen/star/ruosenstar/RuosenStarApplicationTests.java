package com.ruosen.star.ruosenstar;

import com.alibaba.fastjson.JSONObject;
import com.ruosen.star.ruosenstar.mail.MailService;
import com.ruosen.star.ruosenstar.module.po.Mail;
import com.ruosen.star.ruosenstar.module.vo.SysUserVo;
import com.ruosen.star.ruosenstar.mq.producer.TestProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;

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

    @Test
    public void tt() {
        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            System.out.println("ip :" + ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t() throws UnknownHostException {

        String addrUri = "http://api.map.baidu.com/location/ip?ak=F454f8a5efe5e577997931cc01de3974&ip=";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String strbody = restTemplate.exchange(addrUri, HttpMethod.GET, entity, String.class).getBody();

        JSONObject parse = JSONObject.parseObject(strbody);
        String content = parse.getString("content");
        JSONObject jsonObject = JSONObject.parseObject(content);
        String address_detail = jsonObject.getString("address_detail");
        JSONObject jsonObject1 = JSONObject.parseObject(address_detail);
        String city = jsonObject1.getString("city");

        String weatherUrl = "http://api.map.baidu.com/telematics/v3/weather?location=" + city + "&output=json&ak=3p49MVra6urFRGOT9s8UBWr2";
        String body = restTemplate.exchange(weatherUrl, HttpMethod.GET, entity, String.class).getBody();
        System.out.println("buffer:" + body);
    }

}
