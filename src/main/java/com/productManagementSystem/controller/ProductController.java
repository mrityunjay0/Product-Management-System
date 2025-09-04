package com.productManagementSystem.controller;

import com.productManagementSystem.dto.ProductDto;
import com.productManagementSystem.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // CREATE PRODUCT
    @PostMapping("/create")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.createProduct(productDto), HttpStatus.CREATED);
    }

    // GET ALL PRODUCT
    @GetMapping("/getAll")
    public ResponseEntity<List<ProductDto>> getAllProduct(){
        return new ResponseEntity<>(productService.getAllproducts(), HttpStatus.OK);
    }

    // GET PRODUCT BY ID
    @GetMapping("/get/byId")
    public ResponseEntity<ProductDto> getProductById(@RequestBody Long id){
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    // UPDATE PRODUCT
    @PutMapping("/update/byId")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.updateProduct(productDto.getId(),productDto), HttpStatus.OK);
    }

    // DELETE PRODUCT
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product "+id+" deleted.", HttpStatus.OK);
    }
}
