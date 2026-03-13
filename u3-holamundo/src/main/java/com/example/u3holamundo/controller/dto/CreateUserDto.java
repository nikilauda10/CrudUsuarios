package com.example.u3holamundo.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public class CreateUserDto {
    @NotBlank(message = "El nombre es requierdo")
    private String nombre;

    @NotBlank(message = "El apellido es requierdo")
    private String apellido;

    @NotBlank(message = "El correo es requierdo")
    @Email(message = "El corro no es valido")
    private String correo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
