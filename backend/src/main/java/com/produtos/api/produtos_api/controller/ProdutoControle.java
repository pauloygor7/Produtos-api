package com.produtos.api.produtos_api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

//Conecta o java ao navegador web
@RestController
public class ProdutoControle {

    @GetMapping("/")
    public String rota() {
        return "API está funcionando no navegador WEB!";
    }
}
