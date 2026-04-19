package com.example.ordenesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ordenesapi.entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}