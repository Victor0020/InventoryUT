package com.example.inventory.dto;

import lombok.Getter;
import lombok.Setter;

public class ProductDto {
    // Getters y Setters
    @Getter
    private Long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private double unitPrice;
    @Setter
    private Long categoryId;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }
}
