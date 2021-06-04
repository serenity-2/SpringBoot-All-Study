package com.jzjr.mybatisoperating;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.jzjr.mybatisoperating.mapper")
public class MybatisOperatingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisOperatingApplication.class, args);
    }

}
