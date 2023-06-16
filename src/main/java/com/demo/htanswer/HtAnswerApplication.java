package com.demo.htanswer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@MapperScan("com.demo.htanswer.dao")
@SpringBootApplication
public class HtAnswerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HtAnswerApplication.class, args);
    }

}
