package com.shirtms.inventory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "buttons")
public class Button {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String color;

    private int quantity;

    private String size; // e.g., small, medium, large

    private String unit; // e.g., pcs

    // No-Args Constructor
    public Button() {
    }

    // All-Args Constructor
    public Button(Long id, String color, int quantity, String size, String unit) {
        this.id = id;
        this.color = color;
        this.quantity = quantity;
        this.size = size;
        this.unit = unit;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }

    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }

    // Builder Pattern (Manual)
    public static class Builder {
        private Long id;
        private String color;
        private int quantity;
        private String size;
        private String unit;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder size(String size) {
            this.size = size;
            return this;
        }

        public Builder unit(String unit) {
            this.unit = unit;
            return this;
        }

        public Button build() {
            return new Button(id, color, quantity, size, unit);
        }
    }

    @Override
    public String toString() {
        return "Button{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", quantity=" + quantity +
                ", size='" + size + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
