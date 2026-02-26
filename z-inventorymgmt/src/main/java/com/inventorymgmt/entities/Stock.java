package com.inventorymgmt.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "stock")
public class Stock implements Serializable {
    @Id
    @Column(name = "stock_unique_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stockUniqueNo;
    @Column(name = "product_nm")
    private String productName;
    private String category;
    @Column(name = "model_no")
    private String modelNo;
    private int quantity;
    private double price;
}
