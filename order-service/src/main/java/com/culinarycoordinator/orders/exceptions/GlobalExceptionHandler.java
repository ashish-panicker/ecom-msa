package com.culinarycoordinator.orders.exceptions;

import com.culinarycoordinator.orders.common.ErrorResponse;
import com.culinarycoordinator.orders.common.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardResponse<Void>> handleNotFound(ResourceNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(
                        StandardResponse.failure(
                                "Request failed",
                                ErrorResponse.of("ORDER_NOT_FOUND", ex.getMessage())
                        )
                );
    }

}
