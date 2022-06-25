package com.example.fingeso.services;

import com.example.fingeso.models.User;
import com.example.fingeso.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;


import java.awt.geom.QuadCurve2D;
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
        System.out.println("aaaaaaaa");
        return String.format("Tienes en total %s usuarios.",total);
    }

    @GetMapping("/getall")
    public List<User>getAllUsers() {
        return userRepository.getAllUsers();
    }

    @GetMapping(value = "/get-by-rol/{rol}")
    public List<User> getByRol(@PathVariable("rol") Integer rol){
        return userRepository.getByRol(rol);
    }
}