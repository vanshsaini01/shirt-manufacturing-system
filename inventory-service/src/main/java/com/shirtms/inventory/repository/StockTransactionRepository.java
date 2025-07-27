package com.shirtms.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shirtms.inventory.entity.StockTransaction;

public interface StockTransactionRepository extends JpaRepository<StockTransaction, Long> {
}
