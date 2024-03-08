package com.example.Legnomagus.service;

import com.example.Legnomagus.dao.AdminDao;
import com.example.Legnomagus.dao.CategoriaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService{
    @Autowired
    private CategoriaDao categoriaDao;
}
