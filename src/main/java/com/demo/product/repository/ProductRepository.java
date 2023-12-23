package com.demo.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.product.model.Product;

public interface ProductRepository extends JpaRepository<Product,String> {
//    Product findByName(String name);
}
