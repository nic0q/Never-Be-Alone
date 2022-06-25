package com.example.fingeso.models;

public class User {
    private Integer id;
    private String correo;
    private String contrasenia;
    private Integer rol;

    public User(Integer id, String correo, String contrasenia) {
        this.id = id;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public Integer getId() {
        return id;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public Integer getRol() {
        return rol;
    }
    public void setRol(Integer newRol) {
        this.rol = newRol;
    }
}