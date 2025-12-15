package com.example.inventory.exception;

import com.example.inventory.common.ErrorResponse;
import com.example.inventory.common.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InsufficientStockException.class)
    public ResponseEntity<StandardResponse<Void>> handleStock(InsufficientStockException ex) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(
                        StandardResponse.failure(
                                "Stock operation failed",
                                ErrorResponse.of("INSUFFICIENT_STOCK", ex.getMessage())
                        )
                );
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardResponse<Void>> handleNotFound(ResourceNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(
                        StandardResponse.failure(
                                "Request failed",
                                ErrorResponse.of("PRODUCT_NOT_FOUND", ex.getMessage())
                        )
                );
    }
}

