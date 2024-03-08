package com.example.Legnomagus.service;

import com.example.Legnomagus.dao.AdminDao;
import com.example.Legnomagus.dao.CategoriaDao;
import com.example.Legnomagus.dao.ProdottoDao;
import com.example.Legnomagus.model.Categoria;
import com.example.Legnomagus.model.Prodotto;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService{
    @Autowired
    private CategoriaDao categoriaDao;
    @Autowired
    private ProdottoDao prodottoDao;

    @Override
    public Categoria getCategoriaById(int id) {
        return categoriaDao.findById(id).get();
    }

    @Override
    public List<Categoria> getCategorie() {
        return (List<Categoria>) categoriaDao.findAll();
    }

    @Override
    public List<Prodotto> getAllProductsByIdCategoria(int id, HttpSession session) {
        List<Prodotto> prodotti = (List<Prodotto>) prodottoDao.findAll();
        List<Prodotto> prodottiByCategoria = new ArrayList<>();
        for (Prodotto p : prodotti){
            if (p.getCategoria().getId() == id )
                prodottiByCategoria.add(p);
        }
        session.setAttribute("prodotti", prodottiByCategoria);
        return prodottiByCategoria;
    }
}
