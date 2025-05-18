package com.produtos.api.produtos_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.produtos.api.produtos_api.modules.ProdutoModelo;
import com.produtos.api.produtos_api.modules.RespostaModelo;
import com.produtos.api.produtos_api.repository.ProdutoRepositorio;

@Service
public class ProdutoServico {
    @Autowired
    private ProdutoRepositorio pr;

    ProdutoModelo pm = new ProdutoModelo();

    @Autowired
    private RespostaModelo rm;

    public Iterable<ProdutoModelo> listar() {
        return pr.findAll();
    }

    public ResponseEntity<?> cadastrar() {
        if ("".equals(pm.getNome())) {
            rm.setMensagem("O nome do produto é obrigatório!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        } else if ("".equals(pm.getMarca())) {
            rm.setMensagem("A marca do produto é obrigatória!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.CREATED);
        }
    }
}

// 400 do lado do cliente
// 500 do lado do servidor
// 200 sucesso