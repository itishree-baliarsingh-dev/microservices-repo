package com.distributornetwork.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "distributors")
public class Distributor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "distributor_unique_no")
    private int distributorUniqueNo;
    @Column(name = "distributor_code")
    private String distributorCode;
    @Column(name = "distributor_business_nm")
    private String distributorBusinessName;
    @Column(name = "owner_nm")
    private String ownerName;
    @Column(name = "contact_no")
    private String contactNo;
    @Column(name = "email_address")
    private String emailAddress;
}
