package com.inventorymgmt.repositories;

import com.inventorymgmt.entities.Stock;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Integer> {
    List<Stock> findByModelNo(String modelNo);
}
