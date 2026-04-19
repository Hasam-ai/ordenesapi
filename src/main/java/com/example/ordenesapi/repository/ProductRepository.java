package com.example.ordenesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ordenesapi.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}