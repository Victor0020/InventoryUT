package com.example.inventory.facade;

import com.example.inventory.domain.Inventory;
import com.example.inventory.domain.InventoryId;
import com.example.inventory.dto.InventoryDto;
import com.example.inventory.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryFacade {

    @Autowired
    private InventoryService inventoryService;

    public List<InventoryDto> getAllInventories() {
        return inventoryService.getAllInventories().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public InventoryDto getInventoryById(Long productId, Long warehouseId) {
        return convertToDto(inventoryService.getInventoryById(productId, warehouseId));
    }

    public InventoryDto createInventory(InventoryDto inventoryDto) {
        return convertToDto(inventoryService.createInventory(convertToEntity(inventoryDto)));
    }

    public InventoryDto updateInventory(Long productId, Long warehouseId, InventoryDto inventoryDto) {
        return convertToDto(inventoryService.updateInventory(productId, warehouseId, convertToEntity(inventoryDto)));
    }

    public InventoryDto partiallyUpdateInventory(Long productId, Long warehouseId, InventoryDto inventoryDto) {
        return convertToDto(inventoryService.partiallyUpdateInventory(productId, warehouseId, convertToEntity(inventoryDto)));
    }

    public void deleteInventory(Long productId, Long warehouseId) {
        inventoryService.deleteInventory(productId, warehouseId);
    }

    private InventoryDto convertToDto(Inventory inventory) {
        InventoryDto inventoryDto = new InventoryDto();
        inventoryDto.setProductId(inventory.getProductId());
        inventoryDto.setWarehouseId(inventory.getWarehouseId());
        inventoryDto.setQuantity(inventory.getQuantity());
        return inventoryDto;
    }

    private Inventory convertToEntity(InventoryDto inventoryDto) {
        Inventory inventory = new Inventory();
        InventoryId inventoryId = new InventoryId(inventoryDto.getProductId(), inventoryDto.getWarehouseId());
        inventory.setId(2L); // Asignar el InventoryId al campo id
        inventory.setQuantity(inventoryDto.getQuantity());
        return inventory;
    }

}
