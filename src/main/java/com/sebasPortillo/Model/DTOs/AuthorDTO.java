package com.sebasPortillo.Model.DTOs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class AuthorDTO {


    private Long id;
    private String nombre;
    private String nacimiento;
    private String muerte;
    private int edad;
    private List<BookDTO> books;


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

    public List<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public void setEdad(){

        GregorianCalendar hoy = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        GregorianCalendar fecha = new GregorianCalendar();
        try{
            Date aux = sdf.parse(nacimiento);
            fecha.setTime(aux);
            if(muerte != null){
                hoy.setTime(sdf.parse(muerte));
            }
        }catch (ParseException e){
            System.out.println(e.fillInStackTrace().toString());
        }
        int anyoInicioal = fecha.get(Calendar.YEAR);
        int mesInicial = fecha.get(Calendar.MONTH)+1;
        int diaInicial = fecha.get(Calendar.DAY_OF_MONTH);

        int anyoHoy = hoy.get(Calendar.YEAR);
        int mesHoy = hoy.get(Calendar.MONTH)+1;
        int diaHoy = hoy.get(Calendar.DAY_OF_MONTH);

        int edad = anyoHoy - anyoInicioal;

        if(mesHoy < mesInicial){
            edad--;
        }else if(mesHoy == mesInicial){
            if(diaHoy < diaInicial){
                edad--;
            }
        }
        this.edad = edad;
    }

    public String getMuerte() {
        return muerte;
    }

    public void setMuerte(String muerte) {
        this.muerte = muerte;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "AuthorDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nacimiento='" + nacimiento + '\'' +
                ", muerte='" + muerte + '\'' +
                ", edad=" + edad +
                ", books=" + books +
                '}';
    }
}
