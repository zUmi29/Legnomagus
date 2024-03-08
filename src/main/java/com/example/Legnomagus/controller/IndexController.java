package com.example.Legnomagus.controller;

import com.example.Legnomagus.model.Prodotto;
import com.example.Legnomagus.service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class IndexController {
    @Autowired
    private ProdottoService prodottoService;
    @GetMapping
    public String getPage(Model model){
        List<Prodotto> prodotti = prodottoService.getAllProducts();
        model.addAttribute("prodotti", prodotti);
        return "index";
    }
}
