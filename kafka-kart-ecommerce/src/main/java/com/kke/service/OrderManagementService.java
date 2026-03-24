package com.kke.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kke.dto.OrderDto;
import com.kke.entities.CustomerOrder;
import com.kke.repository.CustomerOrderRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderManagementService {
    private final CustomerOrderRepository customerOrderRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Transactional(readOnly = false)
    public int newOrder(OrderDto orderDto) throws JsonProcessingException {
        int orderNo = 0;
        CustomerOrder customerOrder = null;

        customerOrder = new CustomerOrder();
        customerOrder.setCustomerName(orderDto.getCustomerName());
        customerOrder.setOrderDate(LocalDateTime.now());
        customerOrder.setQuantity(orderDto.getQuantity());
        customerOrder.setAmount(orderDto.getAmount());
        customerOrder.setOrderStatus("pending");

        orderNo = customerOrderRepository.save(customerOrder).getOrderNo();

        ObjectMapper objectMapper = new ObjectMapper();
        String order = objectMapper.writeValueAsString(customerOrder);
        kafkaTemplate.send("ordertopic", String.valueOf(customerOrder.getOrderNo()), order);

        return orderNo;
    }

}
