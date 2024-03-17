package com.ngodingsolusi.restapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ngodingsolusi.restapi.dto.ResponseData;
import com.ngodingsolusi.restapi.model.entity.Product;
import com.ngodingsolusi.restapi.services.ProductService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;
    
    @GetMapping
    public Iterable<Product> index() {
        return productService.findAll();
    }

    @GetMapping("/by-name")
    public Iterable<Product> getMethodName(
        @RequestParam(name = "name", required = false) String name,
        @RequestParam(name = "page", required = false) int page
        ) {
        Pageable pageable = PageRequest.of(page, 10);

        return productService.findByName(name, pageable);
    }
    
    
    @PostMapping
    public ResponseEntity<ResponseData<Product>> create(@Valid @RequestBody Product product) {
        ResponseData<Product> responseData = new ResponseData<>();

        responseData.setPayload(productService.save(product));

        return ResponseEntity.ok(responseData);
    }
    
}
