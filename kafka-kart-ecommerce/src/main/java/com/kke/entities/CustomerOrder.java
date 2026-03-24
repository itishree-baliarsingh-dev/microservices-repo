package com.kke.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "customer_orders")
@Data
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_no")
    private int orderNo;
    @Column(name = "order_dt")
    @JsonIgnore
    private LocalDateTime orderDate;
    @Column(name = "customer_nm")
    private String customerName;
    private int quantity;
    private double amount;
    @Column(name = "order_status")
    private String orderStatus;
}
