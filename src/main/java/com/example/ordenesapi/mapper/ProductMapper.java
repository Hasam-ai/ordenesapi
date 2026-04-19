package com.example.ordenesapi.mapper;

import org.springframework.stereotype.Component;
import com.example.ordenesapi.dto.request.ProductRequest;
import com.example.ordenesapi.dto.response.ProductResponse;
import com.example.ordenesapi.entity.Product;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequest request) {
        return Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .stock(request.getStock())
                .build();
    }

    public ProductResponse toResponse(Product product) {
    	return ProductResponse.builder()
    	        .id(product.getId())
    	        .nombre(product.getName())
    	        .precio(product.getPrice())
    	        .stock(product.getStock())
    	        .build();
    }
}