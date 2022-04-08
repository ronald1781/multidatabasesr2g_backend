package com.r2g.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.r2g.model.bdmq.User;
import com.r2g.model.bdpg.Product;
import com.r2g.service.ProductService;
import com.r2g.service.UserService;

@RestController
@RequestMapping("/multibases")
public class TestController {

    @Autowired
    private ProductService proserv;

    @Autowired
    private UserService userserv;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/product")
    public void registrarProduct(@RequestBody Product pro) {
        proserv.registrar(pro);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/user")
    public void registrarUser(@RequestBody User usr) {
        userserv.registrar(usr);
    }

}
