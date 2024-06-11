package com.example.inventory.facade;

import com.example.inventory.domain.Product;
import com.example.inventory.dto.ProductDto;
import com.example.inventory.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductFacade {

    @Autowired
    private ProductService productService;

    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public ProductDto getProductById(Long id) {
        Product product = productService.getProductById(id);
        return convertToDto(product);
    }

    public ProductDto createProduct(ProductDto productDto) {
        Product product = convertToEntity(productDto);
        Product savedProduct = productService.createProduct(product);
        return convertToDto(savedProduct);
    }

    public ProductDto updateProduct(Long id, ProductDto productDto) {
        Product product = convertToEntity(productDto);
        Product updatedProduct = productService.updateProduct(id, product);
        return convertToDto(updatedProduct);
    }

    public ProductDto partiallyUpdateProduct(Long id, ProductDto productDto) {
        Product product = convertToEntity(productDto);
        Product updatedProduct = productService.partiallyUpdateProduct(id, product);
        return convertToDto(updatedProduct);
    }

    public void deleteProduct(Long id) {
        productService.deleteProduct(String.valueOf(id));
    }

    private ProductDto convertToDto(Product product) {
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setUnitPrice(product.getPrice());
        dto.setCategoryId(product.getCategoryId());
        return dto;
    }

    private Product convertToEntity(ProductDto dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getUnitPrice());
        product.setCategoryId(dto.getCategoryId());
        return product;
    }
}
