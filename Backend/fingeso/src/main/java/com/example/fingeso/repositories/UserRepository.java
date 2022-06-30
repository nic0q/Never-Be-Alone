package com.example.fingeso.repositories;

import com.example.fingeso.models.User;
import com.example.fingeso.models.Login;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository{
    int countUsers();
    List<User>getAllUsers();
    List<User>getByRol(Integer rol);
    List<User>getByEmail(String email);
    List<User>getById(Integer id);
    Integer postUser(User user);
    Integer updateRolUser(Integer id_usuario, Integer id_rol);
    Integer autenticacion(String mail, String pass);

    Integer seleccionarFiscal();
    List<User>getAllUsersNoAdmin();
}