package com.Dio.GoF;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GoFApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoFApplication.class, args);
    }

}