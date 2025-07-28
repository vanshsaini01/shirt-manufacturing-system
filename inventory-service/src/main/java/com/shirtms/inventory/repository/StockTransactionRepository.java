package com.shirtms.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shirtms.inventory.entity.StockTransaction;  // <-- MISSING IMPORT (Add this)

public interface StockTransactionRepository extends JpaRepository<StockTransaction, Long> {
    List<StockTransaction> findByType(StockTransaction.TransactionType type);
}
