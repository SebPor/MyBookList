package com.sebasPortillo.Model.DTOs;

public class ListDTO {

    private long id;
    private String titulo;
    private String author;
    private long idBook;
    private long idAuthor;
    private int paginas;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getIdBook() {
        return idBook;
    }

    public void setIdBook(long idBook) {
        this.idBook = idBook;
    }

    public long getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(long idAuthor) {
        this.idAuthor = idAuthor;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    @Override
    public String toString() {
        return "ListDTO{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", author='" + author + '\'' +
                ", idBook=" + idBook +
                ", idAuthor=" + idAuthor +
                ", paginas=" + paginas +
                '}';
    }
}
