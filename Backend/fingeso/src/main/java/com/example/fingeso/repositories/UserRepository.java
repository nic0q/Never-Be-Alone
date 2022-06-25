package com.example.fingeso.repositories;

import com.example.fingeso.models.User;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface UserRepository{
    int countUsers();
    List<User>getAllUsers();
    List<User>getByRol(Integer rol);
}