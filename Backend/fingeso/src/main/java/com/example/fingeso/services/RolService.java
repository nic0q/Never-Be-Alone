package com.example.fingeso.services;

import com.example.fingeso.models.Denuncia;
import com.example.fingeso.models.Rol;
import com.example.fingeso.repositories.RolRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class RolService {
    private final RolRepository rolRepository;
    RolService(RolRepository rolRepository){this.rolRepository=rolRepository;}
    @GetMapping("/count")
    public String countRoles(){
        int total=rolRepository.countRoles();
        return String.format("Tienes en total %s roles.",total);
    }
    @GetMapping("/getall")
    public List<Rol> getAllRoles() {return rolRepository.getAllRoles();
    }
}
