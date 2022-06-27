package com.example.fingeso.services;


import com.example.fingeso.models.Denuncia;
import com.example.fingeso.models.Estamento;
import com.example.fingeso.models.User;
import com.example.fingeso.repositories.EstamentoRepository;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value = "estamento")
public class EstamentoService {
    private final EstamentoRepository estamentoRepository;
    EstamentoService(EstamentoRepository estamentoRepository){this.estamentoRepository=estamentoRepository;}
    @GetMapping("/count")
    public String countEstamentos(){
        int total=estamentoRepository.countEstamentos();
        return String.format("Tienes en total %s estamentos.",total);
    }
    @GetMapping("/getall")
    public List<Estamento>getAllEstamentos() {
        return estamentoRepository.getAllEstamentos();
    }
    @PostMapping(value = "/post-estamento")
    public Integer postUser(@RequestBody Estamento estamento){return estamentoRepository.postEstamento(estamento);}
}
