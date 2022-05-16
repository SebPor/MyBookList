package com.sebasPortillo.Model.DTOs;

public class CommentDTO {

    private Long id;
    private String commnet;
    private UserDTO user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommnet() {
        return commnet;
    }

    public void setCommnet(String commnet) {
        this.commnet = commnet;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "id=" + id +
                ", commnet='" + commnet + '\'' +
                ", user=" + user +
                '}';
    }
}
