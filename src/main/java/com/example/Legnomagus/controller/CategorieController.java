package com.example.Legnomagus.controller;

import com.example.Legnomagus.dao.CategoriaDao;
import com.example.Legnomagus.model.Categoria;
import com.example.Legnomagus.model.Prodotto;
import com.example.Legnomagus.service.CategoriaService;
import com.example.Legnomagus.service.ProdottoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/categorie")
public class CategorieController {
    @Autowired
    private ProdottoService prodottoService;
    @Autowired
    private CategoriaService categoriaService;
    @GetMapping
    public String getPage(Model model, @RequestParam("id")int id, HttpSession session){
        List<Prodotto> prodotti = categoriaService.getAllProductsByIdCategoria(id, session);
        List<Categoria> categorie = categoriaService.getCategorie();
        model.addAttribute("categorie", categorie);
        model.addAttribute("prodotti",prodotti);
        return "categorie";
    }
}
