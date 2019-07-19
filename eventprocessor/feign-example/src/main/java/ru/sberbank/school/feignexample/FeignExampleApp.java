package ru.sberbank.school.feignexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "ru.sberbank.school.feign.client")
@EnableEurekaClient
@SpringBootApplication
public class FeignExampleApp {
    public static void main(String[] args) {
        SpringApplication.run(FeignExampleApp.class, args);
    }
}