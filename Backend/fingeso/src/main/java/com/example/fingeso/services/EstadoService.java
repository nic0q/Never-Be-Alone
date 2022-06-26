package com.example.fingeso.services;

import com.example.fingeso.models.Estado;
import com.example.fingeso.repositories.EstadoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@RequestMapping(value = "estado")
public class EstadoService {
    private final EstadoRepository estadoRepository;
    EstadoService(EstadoRepository estadoRepository){this.estadoRepository=estadoRepository;}
    @GetMapping("/count")
    public String countEstamentos(){
        int total=estadoRepository.countEstados();
        return String.format("Tienes en total %s estados.",total);
    }
    @GetMapping("/getall")
    public List<Estado> getAllEstados() {
        return estadoRepository.getAllEstados();
    }
}
