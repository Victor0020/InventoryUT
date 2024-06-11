package com.example.inventory.services;

import com.example.inventory.domain.Inventory;
import com.example.inventory.domain.InventoryId;
import com.example.inventory.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }

    public Inventory getInventoryById(Long productId, Long warehouseId) {
        return inventoryRepository.findById(new InventoryId(productId, warehouseId)).orElse(null);
    }

    public Inventory createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public Inventory updateInventory(Long productId, Long warehouseId, Inventory inventory) {
        inventory.setId(2L);
        return inventoryRepository.save(inventory);
    }

    public Inventory partiallyUpdateInventory(Long productId, Long warehouseId, Inventory inventory) {
        Inventory existingInventory = inventoryRepository.findById(new InventoryId(productId, warehouseId)).orElse(null);
        if (existingInventory != null) {
            if (inventory.getQuantity() != 0) existingInventory.setQuantity(inventory.getQuantity());
            return inventoryRepository.save(existingInventory);
        } else {
            return null;
        }
    }

    public void deleteInventory(Long productId, Long warehouseId) {
        inventoryRepository.deleteById(new InventoryId(productId, warehouseId));
    }
}
