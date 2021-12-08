package com.chooseking.reed;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.chooseking.reed.mapper")
@SpringBootApplication
public class ReedApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReedApplication.class, args);
    }

}
