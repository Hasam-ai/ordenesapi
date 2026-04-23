package com.example.ordenesapi.dto.request;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class UserRequest {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Email(message = "El correo no es válido")
    @NotBlank(message = "El correo es obligatorio")
    private String correo;

    @Pattern(regexp = "\\d+", message = "El teléfono solo debe contener números")
    @NotBlank(message = "El teléfono es obligatorio")
    private String telefono;
}