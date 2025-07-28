package com.shirtms.inventory.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fabrics")
public class Fabric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // e.g., cotton, polyester

    private String color;

    private double length; // in meters

    private String unit; // e.g., meter, yard

    // No-Args Constructor
    public Fabric() {
    }

    // All-Args Constructor
    public Fabric(Long id, String type, String color, double length, String unit) {
        this.id = id;
        this.type = type;
        this.color = color;
        this.length = length;
        this.unit = unit;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
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
        private String type;
        private String color;
        private double length;
        private String unit;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder length(double length) {
            this.length = length;
            return this;
        }

        public Builder unit(String unit) {
            this.unit = unit;
            return this;
        }

        public Fabric build() {
            return new Fabric(id, type, color, length, unit);
        }
    }

    @Override
    public String toString() {
        return "Fabric{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", length=" + length +
                ", unit='" + unit + '\'' +
                '}';
    }
}
