package com.example.fingeso.services;

import com.example.fingeso.models.Rol;
import com.example.fingeso.repositories.RolRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value = "rol")
public class RolService {
    private final RolRepository rolRepository;
    RolService(RolRepository rolRepository) {this.rolRepository=rolRepository;}
    @GetMapping("/count")
    public String countRoles(){
        int total=rolRepository.countRoles();
        return String.format("Tienes en total %s roles.",total);
    }
    @GetMapping(value = "/get-by-id/{id}")
    public List<Rol> getById(@PathVariable("id") Integer id){
        return rolRepository.getById(id);
    }
    @GetMapping("/getall")
    public List<Rol> getAllRoles() {return rolRepository.getAllRoles();
    }
}
