package com.example.inventory.facade;

import com.example.inventory.domain.Warehouse;
import com.example.inventory.dto.WarehouseDto;
import com.example.inventory.services.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WarehouseFacade {

    @Autowired
    private WarehouseService warehouseService;

    public List<WarehouseDto> getAllWarehouses() {
        return warehouseService.getAllWarehouses().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public WarehouseDto getWarehouseById(Long id) {
        Warehouse warehouse = warehouseService.getWarehouseById(id);
        return convertToDto(warehouse);
    }

    public WarehouseDto createWarehouse(WarehouseDto warehouseDto) {
        Warehouse warehouse = convertToEntity(warehouseDto);
        Warehouse savedWarehouse = warehouseService.createWarehouse(warehouse);
        return convertToDto(savedWarehouse);
    }

    public WarehouseDto updateWarehouse(Long id, WarehouseDto warehouseDto) {
        Warehouse warehouse = convertToEntity(warehouseDto);
        Warehouse updatedWarehouse = warehouseService.updateWarehouse(id, warehouse);
        return convertToDto(updatedWarehouse);
    }

    public WarehouseDto partiallyUpdateWarehouse(Long id, WarehouseDto warehouseDto) {
        Warehouse warehouse = convertToEntity(warehouseDto);
        Warehouse updatedWarehouse = warehouseService.partiallyUpdateWarehouse(id, warehouse);
        return convertToDto(updatedWarehouse);
    }

    public void deleteWarehouse(Long id) {
        warehouseService.deleteWarehouse(id);
    }

    private WarehouseDto convertToDto(Warehouse warehouse) {
        WarehouseDto dto = new WarehouseDto();
        dto.setId(warehouse.getId());
        dto.setName(warehouse.getName());
        dto.setLocation(warehouse.getLocation());
        return dto;
    }

    private Warehouse convertToEntity(WarehouseDto dto) {
        Warehouse warehouse = new Warehouse();
        warehouse.setId(dto.getId());
        warehouse.setName(dto.getName());
        warehouse.setLocation(dto.getLocation());
        return warehouse;
    }
}
