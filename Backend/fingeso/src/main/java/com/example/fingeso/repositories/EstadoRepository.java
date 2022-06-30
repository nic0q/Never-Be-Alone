package com.example.fingeso.repositories;

import com.example.fingeso.models.Estado;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface EstadoRepository {
    int countEstados();
    List<Estado> getAllEstados();
    List<Estado>getById(Integer id);
}
