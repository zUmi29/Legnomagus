package com.example.Legnomagus.service;

import com.example.Legnomagus.dao.AdminDao;
import com.example.Legnomagus.dao.ProdottoDao;
import com.example.Legnomagus.model.Prodotto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdottoServiceImpl implements ProdottoService{
    @Autowired
    private ProdottoDao prodottoDao;

    @Override
    public List<Prodotto> getAllProducts() {
        return (List<Prodotto>) prodottoDao.findAll();
    }

    @Override
    public Prodotto getProductById(int id) {
        return prodottoDao.findById(id).get();
    }

    @Override
    public List<Prodotto> getProductsByCategory(String categoria) {
        List<Prodotto> prodotti = (List<Prodotto>) prodottoDao.findAll();
        List<Prodotto> prodottiByCategory = new ArrayList<>();
        for (Prodotto p : prodotti)
            if (p.getCategoria().getCategoria().equalsIgnoreCase(categoria))
                prodottiByCategory.add(p);
        return prodottiByCategory;
    }
}
