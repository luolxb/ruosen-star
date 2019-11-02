package com.ruosen.star.ruosenstar.controller;

import com.alibaba.fastjson.JSONObject;
import com.ruosen.star.ruosenstar.module.base.ResponseData;
import com.ruosen.star.ruosenstar.service.CommonSequenceService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     LoginController   
 *  * @package    com.ruosen.star.ruosenstar.controller  
 *  * @author Administrator     
 *  * @date   2019/10/4 0004 星期五
 *  * @version V1.0.0
 *  
 */
@Controller
@Slf4j
@Api(tags = "登录")
public class LoginController {

    @Autowired
    private CommonSequenceService commonSequenceService;

    @PostMapping("/login")
    public void login(@RequestParam String name,
                      @RequestParam String password) {
    }

    @GetMapping("/getWeather")
    @ResponseBody
    public ResponseData getWeather() {

        String addrUri = "http://api.map.baidu.com/location/ip?ak=F454f8a5efe5e577997931cc01de3974&ip=";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String strbody = restTemplate.exchange(addrUri, HttpMethod.GET, entity, String.class).getBody();

        JSONObject parse = JSONObject.parseObject(strbody);
        String content = parse.getString("content");
        JSONObject jsonObject = JSONObject.parseObject(content);
        String addressDetail = jsonObject.getString("address_detail");
        JSONObject jsonObject1 = JSONObject.parseObject(addressDetail);
        String city = jsonObject1.getString("city");

        String weatherUrl = "http://api.map.baidu.com/telematics/v3/weather?location=" + city + "&output=json&ak=3p49MVra6urFRGOT9s8UBWr2";
        String body = restTemplate.exchange(weatherUrl, HttpMethod.GET, entity, String.class).getBody();

        JSONObject obj = JSONObject.parseObject(body);

        Map map = JSONObject.toJavaObject(obj, Map.class);
        return new ResponseData().ok(map);
    }

    /**
     * 获取序列
     *
     * @return
     */
    @GetMapping("/generate")
    @ResponseBody
    public ResponseData generate() {
        String generate = commonSequenceService.generate("C_", "yyyyMMdd", 10);
        return new ResponseData().ok("获取序列成功", generate);
    }
}
