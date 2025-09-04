package com.productManagementSystem.mapper;

import com.productManagementSystem.dto.ProductDto;
import com.productManagementSystem.entity.Category;
import com.productManagementSystem.entity.Product;

public class ProductMapper {

    // ENTITY TO DTO
    public static ProductDto toProductDto(Product product){
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getId()
        );
    }

    // DTO TO ENTITY
    public static Product toProductEntity(ProductDto productDto, Category category){
        Product product = new Product();

        product.setCategory(category);
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());

        return product;

    }
}
