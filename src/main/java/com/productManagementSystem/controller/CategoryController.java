package com.productManagementSystem.controller;

import com.productManagementSystem.dto.CategoryDto;
import com.productManagementSystem.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // CREATE CATEGORIES
    @PostMapping("/create")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        return new ResponseEntity<>(categoryService.createCategory(categoryDto), HttpStatus.CREATED);
    }


    // GET ALL CATEGORIES
    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        return new ResponseEntity<List<CategoryDto>>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    // GET CATEGORY BY ID
    @GetMapping("/get/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id){
        return new ResponseEntity<CategoryDto>(categoryService.getCategoryById(id), HttpStatus.OK);
    }


    // DELETE CATEGORY
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return new ResponseEntity<>("Category "+id+" deleted.",HttpStatus.OK);
    }

}