package com.example.computershop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.computershop.mapper")
public class ComputershopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComputershopApplication.class, args);
    }

}
