package com.example.Legnomagus.service;

import com.example.Legnomagus.model.Categoria;
import com.example.Legnomagus.model.Prodotto;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface CategoriaService {
    Categoria getCategoriaById(int id);
    List<Categoria> getCategorie();
    List<Prodotto> getAllProductsByIdCategoria(int id, HttpSession session);
}
