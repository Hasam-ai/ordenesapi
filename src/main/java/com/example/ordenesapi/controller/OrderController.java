package com.example.ordenesapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.example.ordenesapi.service.OrderService;
import com.example.ordenesapi.mapper.OrderMapper;
import com.example.ordenesapi.dto.request.CreateOrderRequest;
import com.example.ordenesapi.dto.response.OrderResponse;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper mapper;

    @PostMapping
    public OrderResponse create(@RequestBody CreateOrderRequest request) {
        return mapper.toResponse(orderService.createOrder(request));
    }
}