package com.example.Legnomagus.service;

import com.example.Legnomagus.dao.AdminDao;
import com.example.Legnomagus.dao.ProdottoDao;
import com.example.Legnomagus.model.Prodotto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class ProdottoServiceImpl implements ProdottoService{
    @Autowired
    private ProdottoDao prodottoDao;
    @Autowired
    private CategoriaService categoriaService;

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

    @Override
    public void eliminaProdotto(int id) {
        prodottoDao.deleteById(id);
    }

    @Override
    public void modificaProdotto(Prodotto prodotto, String nome, MultipartFile immagine, String descrizione, String prezzo, int idCategoria) {
        prodotto.setNome(nome);
        prodotto.setPrezzo(Double.parseDouble(prezzo));
        prodotto.setDescrizione(descrizione);
        prodotto.setCategoria(categoriaService.getCategoriaById(idCategoria));
        if (immagine != null && !immagine.isEmpty()){
        try {
            String formato = immagine.getContentType();
            String immagineCodificata = "data:" + formato + ";base64," + Base64.getEncoder().encodeToString(immagine.getBytes());
            prodotto.setImmagine(immagineCodificata);
        }catch (Exception e){
            System.out.println(e.getMessage());
            }
        }
        prodottoDao.save(prodotto);
    }
}
