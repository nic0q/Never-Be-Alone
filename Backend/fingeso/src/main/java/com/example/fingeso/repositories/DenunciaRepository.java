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
}
