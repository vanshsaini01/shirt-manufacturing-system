package com.shirtms.inventory.dto;

public class InventoryDTO {

    private Long id;
    private String itemName;
    private int quantity;
    private String location;
    private String lastUpdated;

    public InventoryDTO() {}

    public InventoryDTO(Long id, String itemName, int quantity, String location, String lastUpdated) {
        this.id = id;
        this.itemName = itemName;
        this.quantity = quantity;
        this.location = location;
        this.lastUpdated = lastUpdated;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public String getItemName() { return itemName; }
    public int getQuantity() { return quantity; }
    public String getLocation() { return location; }
    public String getLastUpdated() { return lastUpdated; }

    public void setId(Long id) { this.id = id; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setLocation(String location) { this.location = location; }
    public void setLastUpdated(String lastUpdated) { this.lastUpdated = lastUpdated; }
}
