package com.example.Legnomagus.controller;

import com.example.Legnomagus.model.Admin;
import com.example.Legnomagus.model.Categoria;
import com.example.Legnomagus.model.Prodotto;
import com.example.Legnomagus.service.AdminService;
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
@RequestMapping
public class IndexController {
    @Autowired
    private ProdottoService prodottoService;
    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private AdminService adminService;
    /*@GetMapping
    public String getPage(Model model, HttpSession session,
                          @RequestParam(name = "admin",required = false)Admin admin){
        List<Categoria> categorie = categoriaService.getCategorie();
        List<Prodotto> prodotti = prodottoService.getAllProducts();
        model.addAttribute("prodotti", prodotti);
        model.addAttribute("categorie", categorie);
        session.setAttribute("admin",admin);
        System.out.println(session.getAttribute("admin"));
        return "index";
    }*/
    @GetMapping
    public String getPage(Model model, HttpSession session,
                          @RequestParam(name = "username",required = false)String username,
                          @RequestParam(name = "password", required = false)String password,
                          @RequestParam(name = "admin",required = false)Admin admin){
        boolean loginSuccess = adminService.controlloLogin(username, password, session);
        if (loginSuccess){
            return "index";
        }
        List<Categoria> categorie = categoriaService.getCategorie();
        List<Prodotto> prodotti = prodottoService.getAllProducts();
        model.addAttribute("prodotti", prodotti);
        model.addAttribute("categorie", categorie);
        Admin admin1 = (Admin) session.getAttribute("admin");
        model.addAttribute("admin",admin1);
        return "index";
    }
}
