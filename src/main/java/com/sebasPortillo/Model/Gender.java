package com.sebasPortillo.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Genero")
public class Gender implements Serializable {

    @Id
    @Column(name = "id")
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
        return nombre;
    }
}
