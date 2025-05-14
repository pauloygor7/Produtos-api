package com.produtos.api.produtos_api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.produtos.api.produtos_api.modules.ProdutoModelo;
import com.produtos.api.produtos_api.service.ProdutoServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody ProdutoModelo pm) {
        return ps.cadastrar();
    }

}
