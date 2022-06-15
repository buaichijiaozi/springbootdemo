package com.dz.springboard;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
//MapperScan注解指定当前顶目中mapper接口路径的位置 在项目启动的时候会自动加载所有的接口
@MapperScan("com.dz.springboard.mapper")
public class SpringboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringboardApplication.class, args);
    }

}
