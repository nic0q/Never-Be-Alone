package com.example.fingeso.models;

/* Modelo que representa a un usuario dentro de la plataforma, el cual se identifica con un ID y su correo institucional único */

public class User {
    // Atributos
    private Integer id_usuario;
    private String email;
    private String nombres;
    private String apellidos;
    private String password;
    private Integer id_rol;
    private Integer id_estamento;
    // Constructor
    public User(Integer id, String email, String nombres, String apellidos, String password, Integer id_rol, Integer id_estamento) {
        this.id_usuario = id;
        this.email = email;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.password = password;
        this.id_rol = id_rol;
        this.id_estamento = id_estamento;
    }
    // Getters
    public Integer getId() { return id_usuario;}
    public String getCorreo() { return email;}
    public String getNombre() { return nombres;}
    public String getApellidos() { return apellidos;}
    public String getContrasenia() { return password;}
    public Integer getRol() { return id_rol;}
    public Integer getEstamento() {return id_estamento;}

    // Setters
    public void setRol(Integer newRol) { this.id_rol = newRol;}
}