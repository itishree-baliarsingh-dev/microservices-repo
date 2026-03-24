package com.rs;

import com.rs.dto.DistributorDto;
import com.rs.service.DistributorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RetailStoreApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(RetailStoreApplication.class, args);
        DistributorService distributorService = context.getBean(DistributorService.class);

        DistributorDto dto = distributorService.getDistributor("D002");
        System.out.println(dto);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
