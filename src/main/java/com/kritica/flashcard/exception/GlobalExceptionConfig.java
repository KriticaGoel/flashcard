package com.kritica.flashcard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionConfig {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDto> handleException(RuntimeException ex) {
        ProductNotFoundExceptionDto exception = new ProductNotFoundExceptionDto();
        exception.setMessage("Product not found");
        exception.setResolution("Insert correct product id");

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(exception);
    }
}
