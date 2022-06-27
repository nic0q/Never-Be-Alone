package com.example.fingeso.repositories;

import com.example.fingeso.models.Rol;

import java.util.List;

public interface RolRepository {
    int countRoles();
    List<Rol> getAllRoles();
}
