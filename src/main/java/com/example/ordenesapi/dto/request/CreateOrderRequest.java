package com.example.ordenesapi.dto.request;

import lombok.Data;
import java.util.List;

@Data
public class CreateOrderRequest {
    private Long userId;
    private List<OrderItemRequest> items;
}