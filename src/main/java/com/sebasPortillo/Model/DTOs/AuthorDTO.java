package com.sebasPortillo.Model.DTOs;

import java.util.List;

public class AuthorDTO {


    private Long id;
    private String nombre;
    private List<BookDTO> books;


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

    public List<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "AuthorDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", books=" + books +
                '}';
    }
}
