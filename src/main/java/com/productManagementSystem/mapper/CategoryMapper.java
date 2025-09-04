package com.productManagementSystem.mapper;

import com.productManagementSystem.dto.CategoryDto;
import com.productManagementSystem.entity.Category;

public class CategoryMapper {

    // ENTITY TO DTO
    public static CategoryDto toCategoryDto(Category category){
        if(category == null){
            return null;
        }
        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        if (category.getProducts() != null){
            categoryDto.setProducts(category.getProducts().stream()
                    .map(ProductMapper::toProductDto).toList());
        }

        return categoryDto;
    }

    // DTO TO ENTITY
    public static Category toCategoryEntity(CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.getName());
        return category;
    }

}