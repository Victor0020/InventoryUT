package com.example.inventory.repositories;

import com.example.inventory.domain.Inventory;
import com.example.inventory.domain.InventoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, InventoryId> {
}
