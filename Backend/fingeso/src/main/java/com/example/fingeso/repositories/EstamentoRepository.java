package com.example.fingeso.repositories;
import com.example.fingeso.models.Estamento;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface EstamentoRepository {
    int countEstamentos();
    List<Estamento>getAllEstamentos();
    List<Estamento>getById(Integer id);
    Integer postEstamento(Estamento estamento);
}
