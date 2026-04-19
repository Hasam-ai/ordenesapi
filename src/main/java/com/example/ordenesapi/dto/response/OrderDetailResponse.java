package com.example.ordenesapi.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDetailResponse {

    private String nombreProducto;
    private Double precio;
    private Integer cantidad;
    private Double total;
}