package com.shirtms.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shirtms.inventory.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
