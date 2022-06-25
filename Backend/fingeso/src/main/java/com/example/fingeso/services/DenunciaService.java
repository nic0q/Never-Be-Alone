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

    @GetMapping("/get-by-fiscal/{fiscal}")
    @ResponseBody
    public List<Denuncia> getByFiscal(@PathVariable("fiscal") User fiscal){
        return denunciaRepository.getByFiscal(fiscal);
    }

    @GetMapping("/get-denuncias-denunciante/{user}")
    @ResponseBody
    public List<Denuncia> findDenunciaDenunciante(@PathVariable("user") User user){
        return denunciaRepository.findDenunciaDenunciante(user);
    }

    @GetMapping("/get-denuncias-denunciado/{user}")
    @ResponseBody
    public List<Denuncia> findDenunciaDenunciado(@PathVariable("user") User user){
        return denunciaRepository.findDenunciaDenunciado(user);
    }

}
