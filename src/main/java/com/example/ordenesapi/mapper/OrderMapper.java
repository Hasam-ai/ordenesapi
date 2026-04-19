package com.example.ordenesapi.mapper;

import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import com.example.ordenesapi.entity.Order;
import com.example.ordenesapi.dto.response.*;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final UserMapper userMapper;

    public OrderResponse toResponse(Order order) {

        List<OrderDetailResponse> details = order.getDetails().stream()
                .map(d -> OrderDetailResponse.builder()
                        .nombreProducto(d.getProduct().getName())
                        .precio(d.getProduct().getPrice())
                        .cantidad(d.getQuantity())
                        .total(d.getProduct().getPrice() * d.getQuantity())
                        .build()
                ).toList();

        return OrderResponse.builder()
                .id(order.getId())
                .fecha(order.getDate().toString())
                .usuario(userMapper.toResponse(order.getUser()))
                .subtotal(order.getSubtotal())
                .tax(order.getTax())
                .total(order.getTotal())
                .details(details)
                .build();
    }
}