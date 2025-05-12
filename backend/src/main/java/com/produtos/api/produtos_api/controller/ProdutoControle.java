package com.produtos.api.produtos_api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.produtos.api.produtos_api.modules.ProdutoModelo;
import com.produtos.api.produtos_api.service.ProdutoServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ProdutoControle {
    @Autowired
    private ProdutoServico ps;

    @GetMapping("/")
    public String rota() {
        return "API está funcionando no navegador WEB!";
    }

    @GetMapping("/listar")
    public Iterable<ProdutoModelo> listar() {
        return ps.listar();
    }
}
