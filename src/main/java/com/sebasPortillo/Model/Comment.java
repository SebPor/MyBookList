package com.sebasPortillo.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "comentario")
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_sequence")
    @SequenceGenerator(
            name = "comment_sequence",
            sequenceName = "comment_sequence",
            allocationSize = 1
    )
    private long id;

    @Column(name = "comentario")
    private String comment;

    @Column(name = "fk_usuario")
    private int fk_usuario;

    @Column(name = "fk_libro")
    private int fk_libro;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}


