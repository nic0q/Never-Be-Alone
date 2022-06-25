package com.example.fingeso.services;

import com.example.fingeso.models.User;
import com.example.fingeso.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.awt.geom.QuadCurve2D;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value = "users")
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

    @GetMapping("/get-by-rol")
    public List<User> getByRol(Integer rol){
        return userRepository.getByRol(rol);
    }
}