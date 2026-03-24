package com.lbr;

import com.lbr.dto.DistributorDto;
import com.lbr.service.DistributorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SCLApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SCLApplication.class, args);
        DistributorService distributorService = applicationContext.getBean(DistributorService.class);

        DistributorDto distributorDto = distributorService.getDistributor("D001");
        System.out.println(distributorDto);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
