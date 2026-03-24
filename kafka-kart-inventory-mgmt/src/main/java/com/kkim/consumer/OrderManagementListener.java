package com.kkim.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderManagementListener {

    @KafkaListener(topics = "ordertopic", groupId = "ordergroup", autoStartup = "true")
    public void processOrder(String order) {
        System.out.println(order);
    }
}
