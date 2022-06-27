package com.example.fingeso.repositories;

import com.example.fingeso.models.User;
import com.example.fingeso.models.Denuncia;
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
    Boolean verificaCorreo(String correo, String nombre, String apellido1, String apellido2);
    List<Denuncia>getById(Integer id);
    Integer updateDenuncia(Integer id_denuncia, Integer id_estado);
}
