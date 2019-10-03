package com.ruosen.star.ruosenstar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Administrator
 */
@EnableCaching
@EnableSwagger2
@MapperScan("com.ruosen.star.ruosenstar.dao")
@SpringBootApplication
public class RuosenStarApplication {

    public static void main(String[] args) {
        SpringApplication.run(RuosenStarApplication.class, args);
    }

}
