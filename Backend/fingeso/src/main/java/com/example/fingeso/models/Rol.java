package com.example.fingeso.models;

public class Rol {
    Integer id_rol;
    String nombre;

    public Rol(Integer id_rol, String nombre) {
        this.id_rol = id_rol;
        this.nombre = nombre;
    }

    public Integer getId_rol() {
        return id_rol;
    }
    public String getNombre(){
        return nombre;
    }
}

