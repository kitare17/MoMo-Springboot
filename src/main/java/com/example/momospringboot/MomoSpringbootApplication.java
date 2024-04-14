package com.example.momospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MomoSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MomoSpringbootApplication.class, args);
    }

}
