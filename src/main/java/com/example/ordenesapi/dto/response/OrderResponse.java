package com.example.ordenesapi.dto.response;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class OrderResponse {

    private Long id;
    private String fecha;

    private UserResponse usuario;

    private Double subtotal;
    private Double tax;
    private Double total;

    private List<OrderDetailResponse> details;
}