package com.example.fingeso.models;

import org.springframework.format.annotation.DateTimeFormat;

public class VerDenuncia {
    String nombreDenunciado;
    Integer id;
    String apellidosDenunciado;
    String mailDenunciado;
    String nombreDenunciante;
    String apellidosDenunciante;
    String mailDenunciante;
    String estamento;
    String estado;
    String fecha;
    String descripcion;
    String medidas;
    public String getNombreDenunciante() {
        return nombreDenunciante;
    }
    public String getApellidosDenunciante() {
        return apellidosDenunciante;
    }
    public String getMailDenunciante() {
        return mailDenunciante;
    }
    public String getNombreDenunciado() {
        return nombreDenunciado;
    }
    public String getApellidosDenunciado() {
        return apellidosDenunciado;
    }
    public String getMailDenunciado() {
        return mailDenunciado;
    }
    public String getEstamento() {
        return estamento;
    }
    public Integer getId() {
        return id;
    }
    public String getEstado() {
        return estado;
    }
    public String getFecha() {
        return fecha;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getMedidas() {
        return medidas;
    }
    public VerDenuncia(Integer id,String nombreDenunciado, String apellidosDenunciado, String mailDenunciado, String nombreDenunciante, String apellidosDenunciante, String mailDenunciante, String estamento, String estado, String fecha, String descripcion, String medidas) {
        this.id = id;
        this.nombreDenunciante = nombreDenunciante;
        this.apellidosDenunciante = apellidosDenunciante;
        this.mailDenunciante = mailDenunciante;
        this.nombreDenunciado = nombreDenunciado;
        this.apellidosDenunciado = apellidosDenunciado;
        this.mailDenunciado = mailDenunciado;
        this.estamento = estamento;
        this.estado = estado;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.medidas = medidas;
    }
}
