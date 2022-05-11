package com.sebasPortillo.Model;

import javax.persistence.*;

@Entity
@Table(name = "libro")
public class Book {

    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    @Column(
            name = "id",
            updatable = false,
            nullable = false
    )
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "paginas")
    private Integer paginas;

    @Column(name = "sinopsis")
    private String sinopsis;

    @Column(name = "ISBN",nullable = false)
    private String ISBN;

    public Book(){

    }

    public Book(Long id, String titulo, Integer paginas) {
        this.id = id;
        this.titulo = titulo;
        this.paginas = paginas;
    }

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

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", paginas=" + paginas +
                ", sinopsis='" + sinopsis + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }
}
