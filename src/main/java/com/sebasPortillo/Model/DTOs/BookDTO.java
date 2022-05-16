package com.sebasPortillo.Model.DTOs;

import java.util.List;

public class BookDTO {

    private Long id;
    private String titulo;
    private Integer paginas;
    private String sinopsis;
    private String isbn;
    private List<AuthorDTO> authors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<AuthorDTO> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorDTO> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", paginas=" + paginas +
                ", sinopsis='" + sinopsis + '\'' +
                ", isbn='" + isbn + '\'' +
                ", authors=" + authors +
                '}';
    }
}
