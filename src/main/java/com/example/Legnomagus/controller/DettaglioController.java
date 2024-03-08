package com.example.Legnomagus.controller;

import com.example.Legnomagus.model.Prodotto;
import com.example.Legnomagus.service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/dettaglio")
public class DettaglioController {
    @Autowired
    private ProdottoService prodottoService;
    @GetMapping
    public String getPage(Model model, @RequestParam("id")int id){
        Prodotto prodotto = prodottoService.getProductById(id);
        model.addAttribute("prodotto", prodotto);
        return "dettaglio";
    }
}
