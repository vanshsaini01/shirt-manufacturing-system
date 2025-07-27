package com.shirtms.inventory.service;

import java.util.List;

import com.shirtms.inventory.entity.Inventory;

public interface InventoryService {
    Inventory addInventory(Inventory inventory);
    List<Inventory> getAllInventory();
    Inventory getInventoryById(Long id);
    void deleteInventory(Long id);
}
