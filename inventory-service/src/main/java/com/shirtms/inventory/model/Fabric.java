package com.shirtms.inventory.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fabrics")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fabric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private int quantity;

    private String unit;  // e.g., meters, rolls

}
