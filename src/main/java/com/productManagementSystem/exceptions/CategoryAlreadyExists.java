package com.productManagementSystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class CategoryAlreadyExists extends RuntimeException{

    public CategoryAlreadyExists(String message) {
        super(message);
    }
}
