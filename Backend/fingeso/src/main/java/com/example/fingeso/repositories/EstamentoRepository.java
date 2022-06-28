package com.example.fingeso.repositories;
import com.example.fingeso.models.Estamento;
import com.example.fingeso.services.EstamentoService;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface EstamentoRepository {
    int countEstamentos();
    List<Estamento>getAllEstamentos();
    Integer postEstamento(Estamento estamento);
}
