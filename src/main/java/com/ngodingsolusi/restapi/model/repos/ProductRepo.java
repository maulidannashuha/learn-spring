package com.ngodingsolusi.restapi.model.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ngodingsolusi.restapi.model.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
    
    // List<Product> findByNameContains(String name);

    Page<Product> findByNameContains(String name, Pageable pageable);

}
