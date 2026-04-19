package com.example.ordenesapi.dto.request;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private Double price;
    private Integer stock;
}