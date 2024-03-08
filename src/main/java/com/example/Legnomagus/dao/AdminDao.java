package com.example.Legnomagus.dao;

import com.example.Legnomagus.model.Admin;
import com.example.Legnomagus.model.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface AdminDao extends CrudRepository<Admin, Integer> {
    Admin findByUsernameAndPassword(String username, String password);
}
