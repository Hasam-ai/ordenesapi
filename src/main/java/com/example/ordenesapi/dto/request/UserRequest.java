package com.example.ordenesapi.dto.request;

import lombok.Data;

@Data
public class UserRequest {
	private String nombre;
	private String correo;
	private String telefono;
}