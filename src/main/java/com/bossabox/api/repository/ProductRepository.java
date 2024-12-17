package com.bossabox.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bossabox.api.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
