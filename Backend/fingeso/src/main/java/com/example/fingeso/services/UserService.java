package com.example.fingeso.services;

import com.example.fingeso.models.User;
import com.example.fingeso.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value = "user")
public class UserService {
    private final UserRepository userRepository;
    UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @GetMapping("/count")
    public String countUsers(){
        int total=userRepository.countUsers();
        return String.format("Tienes en total %s usuarios.",total);
    }
    @GetMapping("/getall")
    public List<User>getAllUsers() {
        return userRepository.getAllUsers();
    }
    @GetMapping(value = "/get-by-email/{email}")
    public List<User> getByEmail(@PathVariable("email") String email){
        return userRepository.getByEmail(email);
    }
    @GetMapping(value = "/get-by-rol/{rol}")
    public List<User> getByRol(@PathVariable("rol") Integer rol){
        return userRepository.getByRol(rol);
    }
    @GetMapping(value = "/get-by-id/{id}")
    public List<User> getById(@PathVariable("id") Integer id){
        return userRepository.getById(id);
    }
    @PostMapping(value = "/post-user")
    public Integer postUser(@RequestBody User user){return userRepository.postUser(user);}

    @GetMapping(value = "/update-rol")
    Integer updateRolUser(@RequestParam Integer id_usuario, Integer id_rol){
        return userRepository.updateRolUser(id_usuario, id_rol);
    }
    @PostMapping(value = "/auth")
    public Integer autenticacion(@RequestParam String mail, String pass){return userRepository.autenticacion(mail,pass);}
}