package com.example.inventory.services;

import com.example.inventory.domain.Warehouse;
import com.example.inventory.repositories.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    public Warehouse getWarehouseById(Long id) {
        return warehouseRepository.findById(String.valueOf(id)).orElse(null);
    }

    public Warehouse createWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    public Warehouse updateWarehouse(Long id, Warehouse warehouse) {
        warehouse.setId(id);
        return warehouseRepository.save(warehouse);
    }

    public Warehouse partiallyUpdateWarehouse(Long id, Warehouse warehouse) {
        Warehouse existingWarehouse = warehouseRepository.findById(String.valueOf(id)).orElse(null);
        if (existingWarehouse != null) {
            if (warehouse.getName() != null) existingWarehouse.setName(warehouse.getName());
            if (warehouse.getLocation() != null) existingWarehouse.setLocation(warehouse.getLocation());
            return warehouseRepository.save(existingWarehouse);
        } else {
            return null;
        }
    }

    public void deleteWarehouse(Long id) {
        warehouseRepository.deleteById(String.valueOf(id));
    }
}
