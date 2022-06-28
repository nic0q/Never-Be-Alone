package com.example.fingeso.models;

public class Estamento {
    Integer id_estamento;
    String nombre;
    public Estamento(Integer id_estamento, String nombre) {
        this.id_estamento = id_estamento;
        this.nombre = nombre;
    }
    public Integer getId_estamento() {
        return id_estamento;
    }
    public String getNombre(){
        return nombre;
    }
}
