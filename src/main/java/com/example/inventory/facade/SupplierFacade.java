package com.example.inventory.facade;

import com.example.inventory.domain.Supplier;
import com.example.inventory.dto.SupplierDto;
import com.example.inventory.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SupplierFacade {

    @Autowired
    private SupplierService supplierService;

    public List<SupplierDto> getAllSuppliers() {
        return supplierService.getAllSuppliers().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public SupplierDto getSupplierById(Long id) {
        Supplier supplier = supplierService.getSupplierById(id);
        return convertToDto(supplier);
    }

    public SupplierDto createSupplier(SupplierDto supplierDto) {
        Supplier supplier = convertToEntity(supplierDto);
        Supplier savedSupplier = supplierService.createSupplier(supplier);
        return convertToDto(savedSupplier);
    }

    public SupplierDto updateSupplier(Long id, SupplierDto supplierDto) {
        Supplier supplier = convertToEntity(supplierDto);
        Supplier updatedSupplier = supplierService.updateSupplier(id, supplier);
        return convertToDto(updatedSupplier);
    }

    public SupplierDto partiallyUpdateSupplier(Long id, SupplierDto supplierDto) {
        Supplier supplier = convertToEntity(supplierDto);
        Supplier updatedSupplier = supplierService.partiallyUpdateSupplier(id, supplier);
        return convertToDto(updatedSupplier);
    }

    public void deleteSupplier(Long id) {
        supplierService.deleteSupplier(id);
    }

    private SupplierDto convertToDto(Supplier supplier) {
        SupplierDto dto = new SupplierDto();
        dto.setId(supplier.getId());
        dto.setName(supplier.getName());
        dto.setPhone(supplier.getPhone());
        dto.setAddress(supplier.getAddress());
        return dto;
    }

    private Supplier convertToEntity(SupplierDto dto) {
        Supplier supplier = new Supplier();
        supplier.setId(dto.getId());
        supplier.setName(dto.getName());
        supplier.setPhone(dto.getPhone());
        supplier.setAddress(dto.getAddress());
        return supplier;
    }
}
