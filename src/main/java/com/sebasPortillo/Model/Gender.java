package com.sebasPortillo.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Genero")
public class Gender implements Serializable {

    @Id
    @GeneratedValue(generator = "gender_sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "gender_sequence", allocationSize = 1)
    private long id;

    @Column(name = "nombre")
    private String nombre;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        return "Gender{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
