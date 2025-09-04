package com.productManagementSystem.dto;

import java.util.List;

public class CategoryDto {

    private Long id;
    private String name;
    private List<ProductDto> products;

    public CategoryDto() {
    }

    public CategoryDto(String name, List<ProductDto> products) {
        this.name = name;
        this.products = products;
    }

    public CategoryDto(Long id, String name, List<ProductDto> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }
}