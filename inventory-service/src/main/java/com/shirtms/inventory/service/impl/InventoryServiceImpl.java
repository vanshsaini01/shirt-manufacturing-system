package com.shirtms.inventory.service.impl;

import com.shirtms.inventory.entity.Inventory;
import com.shirtms.inventory.entity.StockTransaction;
import com.shirtms.inventory.repository.InventoryRepository;
import com.shirtms.inventory.repository.StockTransactionRepository;
import com.shirtms.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;
    private final StockTransactionRepository stockTransactionRepository;

    @Autowired
    public InventoryServiceImpl(
            InventoryRepository inventoryRepository,
            StockTransactionRepository stockTransactionRepository) {
        this.inventoryRepository = inventoryRepository;
        this.stockTransactionRepository = stockTransactionRepository;
    }

    @Override
    public Inventory getInventoryById(Long id) {
        return inventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory not found with ID: " + id));
    }

    @Override
    public void stockIn(StockTransaction transaction) {
        transaction.setType(StockTransaction.TransactionType.IN);
        transaction.setTransactionDate(LocalDateTime.now());
        stockTransactionRepository.save(transaction);
    }

    @Override
    public void stockOut(StockTransaction transaction) {
        transaction.setType(StockTransaction.TransactionType.OUT);
        transaction.setTransactionDate(LocalDateTime.now());
        stockTransactionRepository.save(transaction);
    }

    @Override
    public List<StockTransaction> getAllTransactions() {
        return stockTransactionRepository.findAll();
    }

    @Override
    public List<StockTransaction> getTransactionsByType(StockTransaction.TransactionType type) {
        return stockTransactionRepository.findByType(type);
    }
}
