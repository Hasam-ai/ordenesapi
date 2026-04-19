package com.example.ordenesapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.ordenesapi.entity.*;
import com.example.ordenesapi.repository.*;
import com.example.ordenesapi.dto.request.*;
import com.example.ordenesapi.exception.ResourceNotFoundException;
import com.example.ordenesapi.exception.BusinessException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public Order createOrder(CreateOrderRequest request) {

        // Validar que la orden tenga productos
        if (request.getItems() == null || request.getItems().isEmpty()) {
            throw new BusinessException("Order cannot be empty");
        }

        // Buscar usuario
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Order order = new Order();
        order.setDate(LocalDateTime.now());
        order.setUser(user);

        List<OrderDetail> details = new ArrayList<>();
        double subtotal = 0;

        for (OrderItemRequest item : request.getItems()) {

            // Buscar producto
            Product product = productRepository.findById(item.getProductId())
                    .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

            // Validar stock
            if (product.getStock() < item.getQuantity()) {
                throw new BusinessException("Insufficient stock for product: " + product.getName());
            }

            // Descontar stock
            product.setStock(product.getStock() - item.getQuantity());

            // Calcular subtotal
            double totalItem = product.getPrice() * item.getQuantity();
            subtotal += totalItem;

            // Crear detalle
            OrderDetail detail = new OrderDetail();
            detail.setProduct(product);
            detail.setQuantity(item.getQuantity());
            detail.setOrder(order);

            details.add(detail);
        }

        // Calcular totales
        double tax = subtotal * 0.16;
        double total = subtotal + tax;

        order.setSubtotal(subtotal);
        order.setTax(tax);
        order.setTotal(total);
        order.setDetails(details);

        return orderRepository.save(order);
    }
}