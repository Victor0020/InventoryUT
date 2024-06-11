package com.example.inventory.controllers;

import com.example.inventory.dto.ProductDto;
import com.example.inventory.facade.ProductFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductFacade productFacade;

    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productFacade.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable String id) {
        return productFacade.getProductById(Long.valueOf(id));
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productFacade.createProduct(productDto);
    }

    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        return productFacade.updateProduct(id, productDto);
    }

    @PatchMapping("/{id}")
    public ProductDto partiallyUpdateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        return productFacade.partiallyUpdateProduct(id, productDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productFacade.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
