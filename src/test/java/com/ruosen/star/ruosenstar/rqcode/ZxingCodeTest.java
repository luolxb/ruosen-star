package com.ruosen.star.ruosenstar.rqcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     ZxingCodeTest   
 *  * @package    com.ruosen.star.ruosenstar.rqcode  
 *  * @author Administrator     
 *  * @date   2019/11/3 0003 星期日
 *  * @version V1.0.0
 *  
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ZxingCodeTest {

    @Autowired
    private ZxingCode zxingCode;

    @Test
    public void zxingCode() {
        Integer width = 300;
        Integer height = 300;

        String format = "png";
        String content = "ZxingCode 二维码";

        zxingCode.zxingCodeGenerate(width, height, format, content);
    }

    @Test
    public void zxingCodeResolving() {
        zxingCode.zxingCodeResolving();
    }
}