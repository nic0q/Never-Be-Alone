package com.example.fingeso.repositories;

import com.example.fingeso.models.Rol;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RolRepository {
    int countRoles();
    List<Rol> getAllRoles();
    List<Rol> getById(Integer id);
}
