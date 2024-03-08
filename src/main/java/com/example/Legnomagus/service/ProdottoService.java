package com.example.Legnomagus.service;

import com.example.Legnomagus.model.Prodotto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProdottoService {
    List<Prodotto> getAllProducts();
    Prodotto getProductById(int id);
    List<Prodotto> getProductsByCategory(String categoria);
    void eliminaProdotto(int id);
    void modificaProdotto(Prodotto prodotto, String nome, MultipartFile immagine, String descrizione, String prezzo , int idCategoria);
}
