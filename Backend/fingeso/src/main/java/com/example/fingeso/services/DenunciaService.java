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


    DenunciaService(DenunciaRepository denunciaRepository){

        this.denunciaRepository = denunciaRepository;
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

    @GetMapping("/get-by-fiscal/{id}")
    @ResponseBody
    public List<Denuncia> getByFiscal(@PathVariable("id") Integer id){
        return denunciaRepository.getByFiscal(id);
    }

    @GetMapping("/get-denuncias-denunciante/{id}")
    @ResponseBody
    public List<Denuncia> findDenunciaDenunciante(@PathVariable("id") Integer id){
        return denunciaRepository.findDenunciaDenunciante(id);
    }

    @GetMapping("/get-denuncias-denunciado/{id}")
    @ResponseBody
    public List<Denuncia> findDenunciaDenunciado(@PathVariable("id") Integer id){
        return denunciaRepository.findDenunciaDenunciado(id);
    }

}
