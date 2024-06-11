package com.example.inventory.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Inventory {
    // Constructor, getters y setters
    private Long id;
    private Long productId;
    private Long warehouseId;
    private int quantity;

}
