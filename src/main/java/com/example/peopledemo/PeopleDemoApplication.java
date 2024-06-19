package com.example.peopledemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.peopledemo.mapper")
public class PeopleDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PeopleDemoApplication.class, args);
    }

}
