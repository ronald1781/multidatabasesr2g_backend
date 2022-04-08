package com.r2g.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.r2g.model.bdpg.Product;
import com.r2g.repo.bdpg.IRepo_bdpg;

@Service
public class ProductService {

    @Autowired
    private IRepo_bdpg repopg;

    public void registrar(Product p) {
        repopg.save(p);
    }

}
