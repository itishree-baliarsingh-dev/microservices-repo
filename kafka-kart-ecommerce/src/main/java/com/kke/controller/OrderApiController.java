package com.kke.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kke.dto.OrderDto;
import com.kke.service.OrderManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderApiController {
    private final OrderManagementService orderManagementService;

    @PostMapping(value = "/new", consumes = {MediaType.APPLICATION_JSON_VALUE}
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> newOrder(@RequestBody OrderDto orderDto) throws JsonProcessingException {
        int orderNo = 0;

        orderNo = orderManagementService.newOrder(orderDto);
        return ResponseEntity.ok(String.valueOf(orderNo));
    }
}
