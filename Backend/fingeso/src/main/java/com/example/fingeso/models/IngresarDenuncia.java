package com.example.fingeso.models;

public class IngresarDenuncia {
    public IngresarDenuncia(String nombre1, String apellido11,  String nombre2, String apellido21, String mail1, String mail2, Integer estamento, String desc, String medidas) {
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido11 = apellido11;
        this.nombre2 = nombre2;
        this.apellido21 = apellido21;
        this.mail1 = mail1;
        this.mail2 = mail2;
        this.estamento = estamento;
        this.desc = desc;
        this.medidas = medidas;
    }
    public String getNombre1() {
        return nombre1;
    }
    public String getNombre2() {
        return nombre2;
    }
    public String getApellido11() {
        return apellido11;
    }
    public String getApellido21() {
        return apellido21;
    }

    public String getMail1() {
        return mail1;
    }

    public String getMail2() {
        return mail2;
    }

    public Integer getEstamento() {
        return estamento;
    }

    public String getDesc() {
        return desc;
    }

    public String getMedidas() {
        return medidas;
    }

    String nombre1;
    String nombre2;
    String apellido11;
    String apellido21;
    String mail1;
    String mail2;
    Integer estamento;
    String desc;
    String medidas;
}
