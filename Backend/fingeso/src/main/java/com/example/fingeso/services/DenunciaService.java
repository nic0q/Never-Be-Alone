package com.example.fingeso.services;

import com.example.fingeso.models.Denuncia;
import com.example.fingeso.models.User;
import com.example.fingeso.repositories.DenunciaRepository;
import com.example.fingeso.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value = "denuncia")
public class DenunciaService {
    private DenunciaRepository denunciaRepository;
    DenunciaService(DenunciaRepository denunciaRepository){
        this.denunciaRepository=denunciaRepository;
    }
    @GetMapping("/count")
    public String countDenuncias(){
        int total=denunciaRepository.countDenuncias();
        return String.format("Tienes en total %s denuncias.",total);
    }
    @GetMapping("/getall")
    public List<Denuncia>getAllDenuncias() {
        return denunciaRepository.getAllDenuncias();
    }
    /*
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
    }*/
    @PostMapping(value = "/post-denuncia")
    public Integer postUser(@RequestBody Denuncia denuncia){return denunciaRepository.postDenuncia(denuncia);}
}