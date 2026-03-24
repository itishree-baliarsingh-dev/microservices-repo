package com.of;

import com.of.dto.DistributorDto;
import com.of.service.DistributorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class OFRSApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(OFRSApplication.class, args);
        DistributorService distributorService = applicationContext.getBean(DistributorService.class);
        DistributorDto distributorDto = distributorService.getDistributor("D002");
        System.out.println(distributorDto);
    }
}
