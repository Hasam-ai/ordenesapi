package com.example.ordenesapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.example.ordenesapi.repository.ProductRepository;
import com.example.ordenesapi.mapper.ProductMapper;
import com.example.ordenesapi.dto.request.ProductRequest;
import com.example.ordenesapi.dto.response.ProductResponse;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    @PostMapping
    public ProductResponse create(@RequestBody ProductRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }
}