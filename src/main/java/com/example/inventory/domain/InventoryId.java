package com.example.inventory.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;

@Embeddable
public class InventoryId implements Serializable {
    private Long productId;
    private Long warehouseId;

    // Constructor
    public InventoryId(Long productId, Long warehouseId) {
        this.productId = productId;
        this.warehouseId = warehouseId;
    }

}
