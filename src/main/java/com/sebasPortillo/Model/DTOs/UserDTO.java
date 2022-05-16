package com.sebasPortillo.Model.DTOs;

public class UserDTO {

    private Long id;
    private String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
