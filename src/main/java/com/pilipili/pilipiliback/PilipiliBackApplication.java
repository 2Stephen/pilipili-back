package com.pilipili.pilipiliback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pilipili.pilipiliback.mapper")
public class PilipiliBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(PilipiliBackApplication.class, args);
    }

}
