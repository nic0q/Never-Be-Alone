package com.example.fingeso.models;

import org.springframework.format.annotation.DateTimeFormat;

public class VerDenuncia {
    String nombreDenunciado;
    Integer id;
    String apellidosDenunciado;
    String mailDenunciado;
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

    public VerDenuncia(Integer id,String nombreDenunciado, String apellidosDenunciado, String mailDenunciado, String estamento, String estado, String fecha, String descripcion, String medidas) {
        this.id = id;
        this.nombreDenunciado = nombreDenunciado;
        this.apellidosDenunciado = apellidosDenunciado;
        this.mailDenunciado = mailDenunciado;
        this.estamento = estamento;
        this.estado = estado;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.medidas = medidas;
    }

    String estamento;
    String estado;
    String fecha;
    String descripcion;
    String medidas;
}
