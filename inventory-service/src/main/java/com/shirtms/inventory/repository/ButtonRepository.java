package com.shirtms.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shirtms.inventory.model.Button;

public interface ButtonRepository extends JpaRepository<Button, Long> {
}
