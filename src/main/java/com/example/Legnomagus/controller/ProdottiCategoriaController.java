package com.example.Legnomagus.controller;

import com.example.Legnomagus.dao.CategoriaDao;
import com.example.Legnomagus.dao.ProdottoDao;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/prodotticategoria")
public class ProdottiCategoriaController {
    @Autowired
    CategoriaDao categoriaDao;

    @Autowired
    ProdottoDao prodottoDao;

    @GetMapping
    public String getPage(HttpSession session){

        return "prodotticategoria";
    }

}
