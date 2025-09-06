package com.productManagementSystem.controller;

import com.productManagementSystem.dto.ProductDto;
import com.productManagementSystem.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('ROLE_SELLER')") //Secured("ROLE_SELLER")
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
    @GetMapping("/get/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    // UPDATE PRODUCT
    @PreAuthorize("hasAuthority('ROLE_SELLER')") //Secured("ROLE_SELLER")
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id,@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.updateProduct(id,productDto), HttpStatus.OK);
    }

    // DELETE PRODUCT
    @PreAuthorize("hasAuthority('ROLE_SELLER')") //Secured("ROLE_SELLER")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product "+id+" deleted.", HttpStatus.OK);
    }
}
