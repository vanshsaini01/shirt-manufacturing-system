package com.shirtms.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shirtms.inventory.model.Fabric;

public interface FabricRepository extends JpaRepository<Fabric, Long> {
}
