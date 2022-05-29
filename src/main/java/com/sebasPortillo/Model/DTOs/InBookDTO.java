package com.sebasPortillo.Model.DTOs;

public class InBookDTO {
    private String titulo;
    private int paginas;
    private String sinopsis;
    private String ISBN;
    private String img;
    private String author;
    private String genders;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenders() {
        return genders;
    }

    public void setGenders(String genders) {
        this.genders = genders;
    }

    @Override
    public String toString() {
        return "InBookDTO{" +
                "titulo='" + titulo + '\'' +
                ", paginas=" + paginas +
                ", sinopsis='" + sinopsis + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", img='" + img + '\'' +
                ", author='" + author + '\'' +
                ", genders='" + genders + '\'' +
                '}';
    }
}
