package com.wentong.countingservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wentong.countingservice.mapper")
public class CountingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CountingServiceApplication.class, args);
    }

}
