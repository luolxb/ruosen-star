package com.ruosen.star.ruosenstar.service.impl;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.ruosen.star.ruosenstar.exception.CustomException;
import com.ruosen.star.ruosenstar.module.Enums.ResultInfoEnum;
import com.ruosen.star.ruosenstar.service.SendSmsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     SendSmsServiceImpl   
 *  * @package    com.ruosen.star.ruosenstar.service.impl  
 *  * @author Administrator     
 *  * @date   2019/11/17 0017 星期日
 *  * @version V1.0.0
 *  
 */
@Slf4j
@Service
public class SendSmsServiceImpl implements SendSmsService {

    /**
     * 手机验证部分配置
     */
    /**
     * 设置超时时间-可自行调整
     */
    final static String DEFAULTCONNECTTIMEOUT = "sun.net.client.defaultConnectTimeout";
    final static String DEFAULTREADTIMEOUT = "sun.net.client.defaultReadTimeout";
    final static String TIMEOUT = "10000";
    /**
     * 初始化ascClient需要的几个参数
     * 短信API产品名称（短信产品名固定，无需修改）
     * 短信API产品域名（接口地址固定，无需修改）
     * 你的accessKeyId,填你自己的 上文配置所得  自行配置
     * 你的accessKeySecret,填你自己的 上文配置所得 自行配置
     */
    final static String PRODUCT = "Dysmsapi";
    final static String DOMAIN = "dysmsapi.aliyuncs.com";
    /**
     * 替换成你的AK (产品密)
     */
    final static String ACCESSKEYID = "LTAI4FhapXksnEErwtkwSpeN";
    final static String ACCESSKEYSECRET = "jxanlpURiZpgRde2hnbKcxg6CKgzlS";
    /**
     * 必填:短信签名-可在短信控制台中找到
     * 阿里云配置你自己的短信签名填入
     */
    final static String SIGNNAME = "ruosen";
    /**
     * 必填:短信模板-可在短信控制台中找到
     * 阿里云配置你自己的短信模板填入
     */
    final static String TEMPLATECODE = "SMS_177551900";

    /**
     * 获取验证码
     *
     * @return
     */
    private static String vcode() {
        String code = String.valueOf((int) (Math.random() * 999999));
        log.info("vcode ==> {}", code);

        return code;
    }

    @Override
    public String sendPhoneCode(String mobile) {
        String code = vcode();
        if (StringUtils.isBlank(mobile)) {
            throw new CustomException(ResultInfoEnum.CODE_IS_NULL);
        }

        /**
         * 短信验证---阿里大于工具
         */
        // 设置超时时间-可自行调整
        System.setProperty(DEFAULTCONNECTTIMEOUT, TIMEOUT);
        System.setProperty(DEFAULTREADTIMEOUT, TIMEOUT);
        // 初始化ascClient需要的几个参数
        final String product = PRODUCT;
        final String domain = DOMAIN;
        // 替换成你的AK
        final String accessKeyId = ACCESSKEYID;
        final String accessKeySecret = ACCESSKEYSECRET;
        // 初始化ascClient,暂时不支持多region
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou",
                accessKeyId, accessKeySecret);
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product,
                    domain);
        } catch (Exception e1) {
            log.error("DefaultProfile error", e1);
        }

        IAcsClient acsClient = new DefaultAcsClient(profile);
        // 组装请求对象
        SendSmsRequest request = new SendSmsRequest();
        // 使用post提交
        request.setMethod(MethodType.POST);
        // 必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
        request.setPhoneNumbers(mobile);
        // 必填:短信签名-可在短信控制台中找到
        request.setSignName(SIGNNAME);
        // 必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(TEMPLATECODE);
        // 可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        // 友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
        request.setTemplateParam("{ \"code\":\"" + code + "\"}");
        // 可选-上行短信扩展码(无特殊需求用户请忽略此字段)
        // request.setSmsUpExtendCode("90997");
        // 可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId(UUID.randomUUID().toString().replace("-", ""));
        // 请求失败这里会抛ClientException异常
        SendSmsResponse sendSmsResponse;
        try {
            sendSmsResponse = acsClient.getAcsResponse(request);
            if (StringUtils.isNotBlank(sendSmsResponse.getCode())
                    && StringUtils.equals("OK", sendSmsResponse.getCode())) {
                // 请求成功
                log.info("获取验证码成功 ==> {}", sendSmsResponse.getMessage());
            } else {
                //如果验证码出错，会输出错误码告诉你具体原因
                log.error("获取验证码失败 ==>{}", sendSmsResponse.getMessage());
            }
        } catch (Exception e) {
            log.error("由于系统维护 无法使用", e);
            throw new CustomException(ResultInfoEnum.ERROR_MSG);
        }

        return code;
    }

    //获取会话缓存内容
    private HttpSession getSession() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        return request.getSession();
    }
}
