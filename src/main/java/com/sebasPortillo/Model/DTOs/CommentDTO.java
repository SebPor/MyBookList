package com.sebasPortillo.Model.DTOs;

public class CommentDTO {

    private Long id;
    private String comment;
    private String user;
    private String book;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String commnet) {
        this.comment = commnet;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "id=" + id +
                ", commnet='" + comment + '\'' +
                ", user=" + user +
                '}';
    }
}
