package com.example.inventory.services;

import com.example.inventory.domain.Product;
import com.example.inventory.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(String.valueOf(id)).orElse(null);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        product.setId(id);
        return productRepository.save(product);
    }

    public Product partiallyUpdateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(String.valueOf(id)).orElse(null);
        if (existingProduct != null) {
            if (product.getName() != null) existingProduct.setName(product.getName());
            if (product.getDescription() != null) existingProduct.setDescription(product.getDescription());
            if (product.getPrice() != null) existingProduct.setPrice(product.getPrice());
            if (product.getCategoryId() != null) existingProduct.setCategoryId(product.getCategoryId());
            return productRepository.save(existingProduct);
        } else {
            return null;
        }
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
