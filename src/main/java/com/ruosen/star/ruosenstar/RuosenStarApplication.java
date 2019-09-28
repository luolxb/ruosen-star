package com.ruosen.star.ruosenstar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 */
@SpringBootApplication
@MapperScan("com.ruosen.star.ruosenstar.dao")
public class RuosenStarApplication {

    public static void main(String[] args) {
        SpringApplication.run(RuosenStarApplication.class, args);
    }

}
