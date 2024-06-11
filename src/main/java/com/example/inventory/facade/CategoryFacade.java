package com.example.inventory.facade;

import com.example.inventory.domain.Category;
import com.example.inventory.dto.CategoryDto;
import com.example.inventory.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryFacade {

    @Autowired
    private CategoryService categoryService;

    public List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public CategoryDto getCategoryById(String id) {
        Category category = categoryService.getCategoryById(id);
        return convertToDto(category);
    }

    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = convertToEntity(categoryDto);
        Category savedCategory = categoryService.createCategory(category);
        return convertToDto(savedCategory);
    }

    public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {
        Category category = convertToEntity(categoryDto);
        Category updatedCategory = categoryService.updateCategory(id, category);
        return convertToDto(updatedCategory);
    }

    public CategoryDto partiallyUpdateCategory(String id, CategoryDto categoryDto) {
        Category category = convertToEntity(categoryDto);
        Category updatedCategory = categoryService.partiallyUpdateCategory(id, category);
        return convertToDto(updatedCategory);
    }

    public void deleteCategory(String id) {
        categoryService.deleteCategory(id);
    }

    private CategoryDto convertToDto(Category category) {
        CategoryDto dto = new CategoryDto();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());
        return dto;
    }

    private Category convertToEntity(CategoryDto dto) {
        Category category = new Category();
        category.setId(dto.getId());
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        return category;
    }
}
