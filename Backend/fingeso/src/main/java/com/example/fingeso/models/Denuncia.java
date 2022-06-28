package com.example.fingeso.models;

public class Denuncia {
    private Integer id_denuncia;
    private Integer id_denunciante;
    private Integer id_denunciado;
    private Integer id_estamento_denunciado;
    private String descripcion;
    private String medidas;
    private Integer id_estado;
    private Integer id_fiscal;
    public Denuncia(Integer id_denuncia, Integer id_denunciante, Integer id_denunciado, Integer id_estamento_denunciado, String descripcion, String medidas, Integer id_estado, Integer id_fiscal) {
        this.id_denuncia = id_denuncia;
        this.id_denunciante = id_denunciante;
        this.id_denunciado = id_denunciado;
        this.id_estamento_denunciado = id_estamento_denunciado;
        this.descripcion=descripcion;
        this.medidas=medidas;
        this.id_estado=id_estado;
        this.id_fiscal = id_fiscal;
    }
    public Integer getIdDenuncia() {
        return id_denuncia;
    }
    public Integer getIdDenunciante() {
        return id_denunciante;
    }
    public Integer getIdDenunciado() {
        return id_denunciado;
    }
    public Integer getIdEstamentoDenunciado(){return id_estamento_denunciado;}
    public String getDescripcion(){return descripcion;}
    public String getMedidas(){return medidas;}
    public Integer getIdEstado() {
        return id_estado;
    }
    public Integer getIdFiscal(){return id_fiscal;}

}
