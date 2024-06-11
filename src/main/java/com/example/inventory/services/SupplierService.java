package com.example.inventory.services;

import com.example.inventory.domain.Supplier;
import com.example.inventory.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(String.valueOf(id)).orElse(null);
    }

    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(Long id, Supplier supplier) {
        supplier.setId(id);
        return supplierRepository.save(supplier);
    }

    public Supplier partiallyUpdateSupplier(Long id, Supplier supplier) {
        Supplier existingSupplier = supplierRepository.findById(String.valueOf(id)).orElse(null);
        if (existingSupplier != null) {
            if (supplier.getName() != null) existingSupplier.setName(supplier.getName());
            if (supplier.getPhone() != null) existingSupplier.setPhone(supplier.getPhone());
            if (supplier.getAddress() != null) existingSupplier.setAddress(supplier.getAddress());
            return supplierRepository.save(existingSupplier);
        } else {
            return null;
        }
    }

    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(String.valueOf(id));
    }
}
