package com.productManagementSystem.service;

import com.productManagementSystem.dto.ProductDto;
import com.productManagementSystem.entity.Category;
import com.productManagementSystem.entity.Product;
import com.productManagementSystem.exceptions.CategoryNotFoundException;
import com.productManagementSystem.exceptions.ProductNotFoundException;
import com.productManagementSystem.mapper.ProductMapper;
import com.productManagementSystem.repository.CategoryRepository;
import com.productManagementSystem.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    CategoryRepository categoryRepository;
    ProductRepository productRepository;

    public ProductService(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    // CREATE PRODUCT
    public ProductDto createProduct(ProductDto productDto){
        /***
         * name, description, price, categoryId
         */

        Category category = categoryRepository.findById(productDto.getCategoryId()).
                orElseThrow(() -> new CategoryNotFoundException("Category ID "
                        + productDto.getCategoryId()+ " not found"));

        Product product = ProductMapper.toProductEntity(productDto,category);
        product = productRepository.save(product);

        return ProductMapper.toProductDto(product);
    }


    // GET ALL PRODUCT
    public List<ProductDto> getAllproducts(){

        return productRepository.findAll()
                .stream().map(ProductMapper::toProductDto).toList();
    }


    // GET PRODUCT BY ID
    public ProductDto getProductById(Long id){

        return productRepository.findById(id)
                .map(ProductMapper::toProductDto)
                .orElseThrow(()-> new ProductNotFoundException("Product ID "+id+ " does not exists."));
    }


    // UPDATE PRODUCT
    public ProductDto updateProduct(Long id, ProductDto productDto){
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new ProductNotFoundException
                        ("Product ID " +id+ " , Category ID " +productDto.getCategoryId()+ " does not exists."));

        Category category = categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(()-> new ProductNotFoundException
                        ("Product ID " +id+ " , Category ID " +productDto.getCategoryId()+ " does not exists."));

        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setCategory(category);

        productRepository.save(product);

        return ProductMapper.toProductDto(product);
    }


    // DELETE PRODUCT
    public void deleteProduct(Long id){

        productRepository.findById(id)
                .orElseThrow(()-> new ProductNotFoundException("Product ID " +id+ " does not exists."));
        productRepository.deleteById(id);
    }
}