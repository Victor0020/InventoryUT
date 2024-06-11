package com.example.inventory.dto;

import lombok.Setter;

public class InventoryDto {
    @Setter
    private Long id;
    @Setter
    private Long productId;
    @Setter
    private Long warehouseId;
    @Setter
    private int quantity;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public int getQuantity() {
        return quantity;
    }

}
