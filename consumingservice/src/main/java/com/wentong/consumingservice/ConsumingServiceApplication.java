package com.wentong.consumingservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wentong.consumingservice.mapper")
public class ConsumingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumingServiceApplication.class, args);
    }

}
