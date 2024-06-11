package com.example.inventory.controllers;

import com.example.inventory.dto.WarehouseDto;
import com.example.inventory.facade.WarehouseFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouses")
public class WarehouseController {

    @Autowired
    private WarehouseFacade warehouseFacade;

    @GetMapping
    public List<WarehouseDto> getAllWarehouses() {
        return warehouseFacade.getAllWarehouses();
    }

    @GetMapping("/{id}")
    public WarehouseDto getWarehouseById(@PathVariable Long id) {
        return warehouseFacade.getWarehouseById(id);
    }

    @PostMapping
    public WarehouseDto createWarehouse(@RequestBody WarehouseDto warehouseDto) {
        return warehouseFacade.createWarehouse(warehouseDto);
    }

    @PutMapping("/{id}")
    public WarehouseDto updateWarehouse(@PathVariable Long id, @RequestBody WarehouseDto warehouseDto) {
        return warehouseFacade.updateWarehouse(id, warehouseDto);
    }

    @PatchMapping("/{id}")
    public WarehouseDto partiallyUpdateWarehouse(@PathVariable Long id, @RequestBody WarehouseDto warehouseDto) {
        return warehouseFacade.partiallyUpdateWarehouse(id, warehouseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWarehouse(@PathVariable Long id) {
        warehouseFacade.deleteWarehouse(id);
        return ResponseEntity.noContent().build();
    }
}
