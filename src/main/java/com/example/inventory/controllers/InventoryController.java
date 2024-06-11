package com.example.inventory.controllers;

import com.example.inventory.dto.InventoryDto;
import com.example.inventory.facade.InventoryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryFacade inventoryFacade;

    @GetMapping
    public List<InventoryDto> getAllInventories() {
        return inventoryFacade.getAllInventories();
    }

    @GetMapping("/{productId}/{warehouseId}")
    public InventoryDto getInventoryById(@PathVariable Long productId, @PathVariable Long warehouseId) {
        return inventoryFacade.getInventoryById(productId, warehouseId);
    }

    @PostMapping
    public InventoryDto createInventory(@RequestBody InventoryDto inventoryDto) {
        return inventoryFacade.createInventory(inventoryDto);
    }

    @PutMapping("/{productId}/{warehouseId}")
    public InventoryDto updateInventory(@PathVariable Long productId, @PathVariable Long warehouseId, @RequestBody InventoryDto inventoryDto) {
        return inventoryFacade.updateInventory(productId, warehouseId, inventoryDto);
    }

    @PatchMapping("/{productId}/{warehouseId}")
    public InventoryDto partiallyUpdateInventory(@PathVariable Long productId, @PathVariable Long warehouseId, @RequestBody InventoryDto inventoryDto) {
        return inventoryFacade.partiallyUpdateInventory(productId, warehouseId, inventoryDto);
    }

    @DeleteMapping("/{productId}/{warehouseId}")
    public ResponseEntity<Void> deleteInventory(@PathVariable Long productId, @PathVariable Long warehouseId) {
        inventoryFacade.deleteInventory(productId, warehouseId);
        return ResponseEntity.noContent().build();
    }
}