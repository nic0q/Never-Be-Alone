package com.example.fingeso.repositories;

import com.example.fingeso.models.IngresarDenuncia;
import com.example.fingeso.models.Denuncia;
import com.example.fingeso.models.VerDenuncia;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DenunciaRepository {
    int countDenuncias();
    List<Denuncia> getAllDenuncias();
    List<Denuncia> getByFiscal(Integer fiscalID);
    List<Denuncia> findDenunciaDenunciante(Integer userID);
    List<Denuncia> findDenunciaDenunciado(Integer userID);
    Integer postDenuncia(Denuncia denuncia);
    Boolean verificaCorreo(String correo, String nombre, String apellido1);
    List<Denuncia>getById(Integer id);
    List<Denuncia>getByEmail(String email);
    List<VerDenuncia>showDenuncia(Integer denuncia);
    List<VerDenuncia>showDenunciaFiscal(Integer denuncia);
    Integer updateDenuncia(Integer id_denuncia, Integer id_estado);
    Integer crearDenuncia(IngresarDenuncia denuncia);
}
