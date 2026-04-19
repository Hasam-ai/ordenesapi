package com.example.ordenesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ordenesapi.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}