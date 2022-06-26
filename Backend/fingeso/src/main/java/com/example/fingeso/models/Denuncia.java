package com.example.fingeso.models;

public class Denuncia {
    // Denunciante
    private Integer denuncianteID;
    private Integer estamento;
    private String hechos;
    private String medidasPrevencion;

    // Denunciado
    private Integer denunciadoID;

    private Integer estado;
    private Integer fiscalID;

    public Denuncia(Integer denuncianteID, String hechos, Integer estamento, String medidasPrevencion, Integer denunciadoID, Integer estado, Integer fiscal) {
        this.denuncianteID = denuncianteID;
        this.estamento = estamento;
        this.hechos = hechos;
        this.medidasPrevencion = medidasPrevencion;
        this.denunciadoID = denunciadoID;
        this.estado = estado;
        this.fiscalID = fiscal;
    }
    public Integer getIdDenunciante() {
        return denuncianteID;
    }

    public Integer getEstamento() {
        return estamento;
    }

    public String getHechos() {
        return hechos;
    }

    public String getMedidas() {
        return medidasPrevencion;
    }

    public Integer getIdDenunciado() {
        return denunciadoID;
    }

    public Integer getEstado() {
        return estado;
    }

    public Integer getFiscal() {
        return fiscalID;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
