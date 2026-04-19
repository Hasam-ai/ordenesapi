package com.example.ordenesapi.mapper;

import org.springframework.stereotype.Component;
import com.example.ordenesapi.dto.request.UserRequest;
import com.example.ordenesapi.dto.response.UserResponse;
import com.example.ordenesapi.entity.User;

@Component
public class UserMapper {

    public User toEntity(UserRequest request) {
        return User.builder()
        		.name(request.getNombre())
        		.email(request.getCorreo())
        		.phone(request.getTelefono())
                .build();
    }

    public UserResponse toResponse(User user) {
    	return UserResponse.builder()
    	        .id(user.getId())
    	        .nombre(user.getName())
    	        .correo(user.getEmail())
    	        .telefono(user.getPhone())
    	        .build();
    }
}