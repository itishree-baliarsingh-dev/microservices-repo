package com.ses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SuzkiEurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SuzkiEurekaServerApplication.class, args);
    }
}
