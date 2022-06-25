package com.example.fingeso.services;

import com.example.fingeso.models.Denuncia;
import com.example.fingeso.models.User;
import com.example.fingeso.repositories.DenunciaRepository;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value = "denuncias")
public class DenunciaService {
    private DenunciaRepository denunciaRepository;

    @GetMapping("/count")
    public String countDenuncias(){
        int total=denunciaRepository.countDenuncias();
        return String.format("Tienes en total %s denuncias.",total);
    }

    @GetMapping("/get-by-fiscal")
    @ResponseBody
    public List<Denuncia> getByFiscal(User fiscal){
        return denunciaRepository.getByFiscal(fiscal);
    }

    @GetMapping("/get-denuncias-denunciante")
    @ResponseBody
    public List<Denuncia> findDenunciaDenunciante(User user){
        return denunciaRepository.findDenunciaDenunciante(user);
    }

    @GetMapping("/get-denuncias-denunciado")
    @ResponseBody
    public List<Denuncia> findDenunciaDenunciado(User user){
        return denunciaRepository.findDenunciaDenunciado(user);
    }

}
