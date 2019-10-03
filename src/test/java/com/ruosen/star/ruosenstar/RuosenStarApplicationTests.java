package com.ruosen.star.ruosenstar;

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

}
