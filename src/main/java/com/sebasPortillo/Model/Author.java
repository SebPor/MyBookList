package com.sebasPortillo.Model;

import javax.persistence.*;

@Entity
@Table(name ="autor")
public class Author {

    @Id
    @SequenceGenerator(
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_sequence"
    )
    @Column(
            name = "id",
            updatable = false,
            nullable = false
    )
    private Long id;

    @Column(
            name = "nombre"
    )
    private String nombre;

    public Author(){

    }

    public Author(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

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
        return "Author{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
