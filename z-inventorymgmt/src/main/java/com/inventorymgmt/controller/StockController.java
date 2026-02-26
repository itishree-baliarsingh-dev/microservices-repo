package com.inventorymgmt.controller;

import com.inventorymgmt.dto.Stock;
import com.inventorymgmt.exception.NotFoundException;
import com.inventorymgmt.service.StockService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
@AllArgsConstructor
public class StockController {
    private final StockService stockService;

    @GetMapping(value = "/{stockName}/availability")
    public Stock getStock(@PathVariable("stockName") String modelNo) {
        return stockService.getStock(modelNo);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException e) {
        return ResponseEntity.of(ProblemDetail
                        .forStatusAndDetail(HttpStatusCode.valueOf(404), "Stock Not Available"))
                .build();
    }
}
