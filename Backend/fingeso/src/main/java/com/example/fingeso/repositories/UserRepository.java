package com.example.fingeso.repositories;

import com.example.fingeso.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Repository
public interface UserRepository{
    int countUsers();
    List<User>getAllUsers();
    List<User>getByRol(Integer rol);
    List<User>getById(Integer id);
    Integer postUser(@RequestBody User user);
}