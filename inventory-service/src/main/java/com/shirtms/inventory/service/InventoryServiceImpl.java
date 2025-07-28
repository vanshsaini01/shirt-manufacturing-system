package com.shirtms.inventory.service.impl;

import com.shirtms.inventory.dto.InventoryRequestDTO;
import com.shirtms.inventory.entity.InventoryItem;
import com.shirtms.inventory.entity.StockTransaction;
import com.shirtms.inventory.entity.StockTransaction.TransactionType;
import com.shirtms.inventory.repository.InventoryRepository;
import com.shirtms.inventory.repository.StockTransactionRepository;
import com.shirtms.inventory.service.InventoryService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;
    private final StockTransactionRepository stockTransactionRepository;

    public InventoryServiceImpl(InventoryRepository inventoryRepository, StockTransactionRepository stockTransactionRepository) {
        this.inventoryRepository = inventoryRepository;
        this.stockTransactionRepository = stockTransactionRepository;
    }

    @Override
    public InventoryItem addInventoryItem(InventoryItem item) {
        return inventoryRepository.save(item);
    }

    @Override
    public InventoryItem stockIn(InventoryRequestDTO request) {
        Optional<InventoryItem> optionalItem = inventoryRepository.findByItemName(request.getItemName());
        InventoryItem item = optionalItem.orElseGet(() -> new InventoryItem(request.getItemType(), request.getItemName(), 0, 10));

        item.setCurrentQuantity(item.getCurrentQuantity() + request.getQuantity());
        inventoryRepository.save(item);

        StockTransaction transaction = new StockTransaction();
        transaction.setType(TransactionType.IN);
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setItemName(item.getItemName());
        transaction.setQuantity(request.getQuantity());
        stockTransactionRepository.save(transaction);

        return item;
    }

    @Override
    public InventoryItem stockOut(InventoryRequestDTO request) {
        Optional<InventoryItem> optionalItem = inventoryRepository.findByItemName(request.getItemName());
        if (optionalItem.isEmpty()) {
            throw new RuntimeException("Item not found: " + request.getItemName());
        }

        InventoryItem item = optionalItem.get();
        if (item.getCurrentQuantity() < request.getQuantity()) {
            throw new RuntimeException("Insufficient stock for: " + item.getItemName());
        }

        item.setCurrentQuantity(item.getCurrentQuantity() - request.getQuantity());
        inventoryRepository.save(item);

        StockTransaction transaction = new StockTransaction();
        transaction.setType(TransactionType.OUT);
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setItemName(item.getItemName());
        transaction.setQuantity(request.getQuantity());
        stockTransactionRepository.save(transaction);

        return item;
    }

    @Override
    public List<InventoryItem> getAllInventory() {
        return inventoryRepository.findAll();
    }

    @Override
    public List<InventoryItem> getLowStockItems() {
        return inventoryRepository.findAll()
                .stream()
                .filter(item -> item.getCurrentQuantity() <= item.getMinimumThreshold())
                .toList();
    }
}
