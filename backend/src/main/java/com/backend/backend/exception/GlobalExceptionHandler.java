package com.backend.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Validation errors handle
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

   @ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class)
public ResponseEntity<Map<String, String>> handleEmptyBody(HttpMessageNotReadableException ex) {
    Map<String, String> errors = new HashMap<>();
    
    // Manually define required fields errors (Laravel style)
    errors.put("username", "Username is required");
    errors.put("email", "Email is required");
    errors.put("password", "Password is required");
    errors.put("mobile", "Mobile no is required");  
    errors.put("email", "Email already exists");

    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
}


}
