package com.example.ordenesapi.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
	private Long id;
	private String nombre;
	private String correo;
	private String telefono;
}