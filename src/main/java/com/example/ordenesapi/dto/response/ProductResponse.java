package com.example.ordenesapi.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {
    private Long id;
    private String nombre;
    private Double precio;
    private Integer stock;
}