package com.productManagementSystem.service;

import com.productManagementSystem.dto.CategoryDto;
import com.productManagementSystem.entity.Category;
import com.productManagementSystem.exceptions.CategoryAlreadyExists;
import com.productManagementSystem.exceptions.CategoryNotFoundException;
import com.productManagementSystem.mapper.CategoryMapper;
import com.productManagementSystem.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    // CREATE CATEGORY
    public CategoryDto createCategory(CategoryDto categoryDto){

        Optional<Category> optionalCategory = categoryRepository.findByName(categoryDto.getName());
        if(optionalCategory.isPresent()){
            throw new CategoryAlreadyExists("Category " + categoryDto.getName() + " already exists.");
        }

        Category category = CategoryMapper.toCategoryEntity(categoryDto);
        categoryRepository.save(category);

        return CategoryMapper.toCategoryDto(category);

//        return CategoryMapper.toCategoryDto(categoryRepository.save(CategoryMapper.toCategoryEntity(categoryDto)));
    }


    // GET ALL CATEGORIES
    public List<CategoryDto> getAllCategories(){

        return categoryRepository.findAll().stream().
                map(CategoryMapper::toCategoryDto).toList();
    }


    // GET CATEGORY BY ID
    public CategoryDto getCategoryById(Long id){

        return categoryRepository.findById(id)
                .map(CategoryMapper::toCategoryDto)
                .orElseThrow(()-> new CategoryNotFoundException("Category ID "+ id + " does not exists."));
    }

    // DELETE CATEGORY
    public void deleteCategory(Long id){

        categoryRepository.findById(id)
                .orElseThrow(()-> new CategoryNotFoundException("Category ID "+id+" does not exists."));
        categoryRepository.deleteById(id);
    }
}