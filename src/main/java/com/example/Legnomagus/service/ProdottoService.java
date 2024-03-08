package com.example.Legnomagus.service;

import com.example.Legnomagus.model.Prodotto;

import java.util.List;

public interface ProdottoService {
    List<Prodotto> getAllProducts();
    Prodotto getProductById(int id);
    List<Prodotto> getProductsByCategory(String categoria);
}
