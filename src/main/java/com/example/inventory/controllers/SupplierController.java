package com.example.inventory.controllers;

import com.example.inventory.dto.SupplierDto;
import com.example.inventory.facade.SupplierFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierFacade supplierFacade;

    @GetMapping
    public List<SupplierDto> getAllSuppliers() {
        return supplierFacade.getAllSuppliers();
    }

    @GetMapping("/{id}")
    public SupplierDto getSupplierById(@PathVariable Long id) {
        return supplierFacade.getSupplierById(id);
    }

    @PostMapping
    public SupplierDto createSupplier(@RequestBody SupplierDto supplierDto) {
        return supplierFacade.createSupplier(supplierDto);
    }

    @PutMapping("/{id}")
    public SupplierDto updateSupplier(@PathVariable Long id, @RequestBody SupplierDto supplierDto) {
        return supplierFacade.updateSupplier(id, supplierDto);
    }

    @PatchMapping("/{id}")
    public SupplierDto partiallyUpdateSupplier(@PathVariable Long id, @RequestBody SupplierDto supplierDto) {
        return supplierFacade.partiallyUpdateSupplier(id, supplierDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
        supplierFacade.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }
}