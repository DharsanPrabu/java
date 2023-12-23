package com.demo.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.product.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
    // You can define additional methods here if needed
}
