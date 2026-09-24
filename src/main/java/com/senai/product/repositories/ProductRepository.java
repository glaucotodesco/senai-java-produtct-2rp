package com.senai.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.product.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
