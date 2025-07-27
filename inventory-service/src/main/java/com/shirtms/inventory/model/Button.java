package com.shirtms.inventory.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "buttons")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Button {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String color;

    private int quantity;

    private String size; // e.g., small, medium, large

    private String unit; // e.g., pcs
}
