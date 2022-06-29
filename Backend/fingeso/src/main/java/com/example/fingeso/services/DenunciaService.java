package com.example.fingeso.services;

import com.example.fingeso.models.Denuncia;
import com.example.fingeso.models.IngresarDenuncia;
import com.example.fingeso.models.Rol;
import com.example.fingeso.repositories.DenunciaRepository;
import org.springframework.web.bind.annotation.*;
import com.example.fingeso.models.VerDenuncia;
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
    @GetMapping(value = "/get-by-id/{id}")
    public List<Denuncia> getById(@PathVariable("id") Integer id){
        return denunciaRepository.getById(id);
    }
    @PostMapping(value = "/post-denuncia")
    public Integer postDenuncia(@RequestBody Denuncia denuncia){return denunciaRepository.postDenuncia(denuncia);}

    @PutMapping(value = "/update-denuncia/{id}")
    public Integer updateDenuncia(@PathVariable("id") Integer id, @RequestParam String id_estado){
        return denunciaRepository.updateDenuncia(id, id_estado);
    }
    @PostMapping(value = "/crear-denuncia")
    public Integer crearDenuncia(@RequestBody IngresarDenuncia denuncia){return denunciaRepository.crearDenuncia(denuncia);}
    @GetMapping("/show-denuncia/{id}")
    public List<VerDenuncia> showDenuncia(@PathVariable("id") Integer id) {return denunciaRepository.showDenuncia(id);}
    @GetMapping("/show-denuncia-realizada/{id}")
    public List<VerDenuncia>showDenunciaRealizada(@PathVariable("id") Integer id) {return denunciaRepository.showDenunciaRealizada(id);}
    @GetMapping("/show-denuncia-contra/{id}")
    public List<VerDenuncia>showDenunciaContra(@PathVariable("id") Integer id) {return denunciaRepository.showDenunciaContra(id);}
    @GetMapping("/show-denuncia-fiscal/{id}")
    public List<VerDenuncia>showDenunciaFiscal(@PathVariable("id") Integer id) {return denunciaRepository.showDenunciaFiscal(id);}
}
