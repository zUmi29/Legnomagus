package com.example.Legnomagus.controller;

import com.example.Legnomagus.model.Categoria;
import com.example.Legnomagus.model.Prodotto;
import com.example.Legnomagus.service.CategoriaService;
import com.example.Legnomagus.service.ProdottoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/modifica")
public class ModificaController {
    @Autowired
    private ProdottoService prodottoService;
    @Autowired
    private CategoriaService categoriaService;
    private Prodotto prodotto;
    @GetMapping
    public String getPage(Model model, HttpSession session,@RequestParam(name = "id",required = false)Integer id){
       if (session.getAttribute("admin")== null){
            return "redirect:/";
       }
        prodotto = new Prodotto();
        List<Categoria> categorieNav = categoriaService.getCategorie();
        List<Prodotto> prodotti = prodottoService.getAllProducts();
        List<Categoria> categorie = categoriaService.getCategorie();
        prodotto = id == null ? new Prodotto() : prodottoService.getProductById(id);//l'id del libro è null creo nu nuovo libro senno getLibro
        model.addAttribute("categorieNav", categorieNav);
        model.addAttribute("categorie", categorie);
        model.addAttribute("prodotto",prodotto);
        model.addAttribute("prodotti",prodotti);
        return "modifica";
    }
    @PostMapping
    public String formManager(@RequestParam("nome")String nome,
                              @RequestParam("prezzo") String prezzo,
                              @RequestParam("descrizione")String descrizione,
                              @RequestParam("categoria")int idCategoria,
                              @RequestParam(name = "immagine",required = false) MultipartFile immagine){
        prodottoService.modificaProdotto(prodotto,nome,immagine,descrizione,prezzo,idCategoria);
        return "redirect:/modifica";
    }
    @GetMapping("/elimina")
    public String eliminaProdotto(@RequestParam ("id")int id){
        prodottoService.eliminaProdotto(id);
        return "redirect:/modifica";
    }
}
