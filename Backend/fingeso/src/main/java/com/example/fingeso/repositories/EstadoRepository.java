package com.example.fingeso.repositories;

import com.example.fingeso.models.Estado;

import java.util.List;

public interface EstadoRepository {
    int countEstados();
    List<Estado> getAllEstados();
}
