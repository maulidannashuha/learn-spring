package com.ngodingsolusi.restapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ngodingsolusi.restapi.model.entity.Product;
import com.ngodingsolusi.restapi.model.repos.ProductRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {
    
    @Autowired
    private ProductRepo productRepo;

    public Product save(Product product){
        return productRepo.save(product);
    }

    public Product findOne(Long id){
        return productRepo.findById(id).get();
    }

    public Iterable<Product> findAll(){
        return productRepo.findAll();
    }

    public void delete(Long id){
        productRepo.deleteById(id);
    }

    public Page<Product> findByName(String name, Pageable pageable){
        return productRepo.findByNameContains(name, pageable);
    }

}
