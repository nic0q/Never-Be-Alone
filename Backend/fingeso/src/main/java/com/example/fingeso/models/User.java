package com.example.fingeso.models;

public class User {
    private Integer id_usuario;
    private String email;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String password;
    private Integer id_rol;
    private Integer id_estamento;
    public User(Integer id, String email, String nombre, String primerApellido, String segundoApellido, String password, Integer id_rol, Integer id_estamento) {
        this.id_usuario = id;
        this.email = email;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.password = password;
        this.id_rol = id_rol;
        this.id_estamento = id_estamento;
    }
    public Integer getId() {
        return id_usuario;
    }
    public String getCorreo() {
        return email;
    }
    public String getNombre() {
        return nombre;
    }
    public String getPrimerApellido() {
        return primerApellido;
    }
    public String getSegundoApellido() {
        return segundoApellido;
    }
    public String getContrasenia() {
        return password;
    }
    public Integer getRol() { return id_rol;}
    public Integer getEstamento() {return id_estamento;}
    public void setRol(Integer newRol) {
        this.id_rol = newRol;
    }
}