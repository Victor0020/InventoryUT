package com.example.inventory.controllers;

import com.example.inventory.dto.CategoryDto;
import com.example.inventory.facade.CategoryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryFacade categoryFacade;

    @GetMapping
    public List<CategoryDto> getAllCategories() {
        return categoryFacade.getAllCategories();
    }

    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable String id) {
        return categoryFacade.getCategoryById(id);
    }

    @PostMapping
    public CategoryDto createCategory(@RequestBody CategoryDto categoryDto) {
        return categoryFacade.createCategory(categoryDto);
    }

    @PutMapping("/{id}")
    public CategoryDto updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
        return categoryFacade.updateCategory(id, categoryDto);
    }

    @PatchMapping("/{id}")
    public CategoryDto partiallyUpdateCategory(@PathVariable String id, @RequestBody CategoryDto categoryDto) {
        return categoryFacade.partiallyUpdateCategory(id, categoryDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable String id) {
        categoryFacade.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
