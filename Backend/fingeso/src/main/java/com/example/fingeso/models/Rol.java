package com.example.fingeso.models;

/* Modelo que representa el rol que posee un usuario, lo cual le permite acceder a distintas funcionalidades dentro de la plataforma.
* Posee un ID y el nombre del rol */
public class Rol {
    // Atributos
    Integer id_rol;
    String nombre;

    // Constructor
    public Rol(Integer id_rol, String nombre) {
        this.id_rol = id_rol;
        this.nombre = nombre;
    }

    // Getters
    public Integer getId_rol() { return id_rol;}
    public String getNombre(){ return nombre;}
}

