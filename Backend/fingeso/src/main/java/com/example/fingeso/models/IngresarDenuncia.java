package com.example.fingeso.models;

public class IngresarDenuncia {
    public String getNombre1() {
        return nombre1;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public String getApellido2() {
        return apellido2;
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
    public String getDescrip() {
        return desc;
    }
    public String getMedidas() {
        return medidas;
    }
    public IngresarDenuncia(String nombre1, String apellido1, String nombre2, String apellido2, String mail1, String mail2, Integer estamento, String desc, String medidas) {
        this.nombre1 = nombre1;
        this.apellido1 = apellido1;
        this.nombre2 = nombre2;
        this.apellido2 = apellido2;
        this.mail1 = mail1;
        this.mail2 = mail2;
        this.estamento = estamento;
        this.desc = desc;
        this.medidas = medidas;
    }
    String nombre1;
    String apellido1;
    String nombre2;
    String apellido2;
    String mail1;
    String mail2;
    Integer estamento;
    String desc;
    String medidas;
}
