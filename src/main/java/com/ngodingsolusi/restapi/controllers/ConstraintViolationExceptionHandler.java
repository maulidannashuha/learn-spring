package com.ngodingsolusi.restapi.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ngodingsolusi.restapi.dto.ResponseData;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class ConstraintViolationExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
        ResponseData<Object> responseData = new ResponseData<>();

        List<String> details = ex.getConstraintViolations().stream()
                .map(e -> e.getMessage())
                .toList();

        responseData.setMessages(details);

        return ResponseEntity.badRequest().body(responseData);
    }
    
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Object> handleIllegalStateException(IllegalStateException ex) {
        ResponseData<Object> responseData = new ResponseData<>();

        responseData.getMessages().add(ex.getMessage());

        return ResponseEntity.badRequest().body(responseData);
    }

}