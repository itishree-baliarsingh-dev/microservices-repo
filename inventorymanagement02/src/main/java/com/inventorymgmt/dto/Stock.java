package com.inventorymgmt.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName = "of")
public class Stock {
    private String stockName;
    private int quantity;
    private double price;
    private String modelNo;
}
