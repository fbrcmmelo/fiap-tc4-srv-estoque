package com.fiap.tc4_srv_estoque.controller;

import com.fiap.tc4_srv_estoque.consumer.ProdutoRequest;
import com.fiap.tc4_srv_estoque.usecase.IAdicionarProdutoUseCase;
import com.fiap.tc4_srv_estoque.usecase.IListarProdutoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/estoque")
public class EstoqueController {

    private final IAdicionarProdutoUseCase adicionarProdutoUseCase;
    private final IListarProdutoUseCase listarEstoqueUsece;

    @PostMapping
    public ResponseEntity<Void> adicionarProduto(@RequestBody ProdutoRequest request) {
        adicionarProdutoUseCase.adicionar(request.produtoId(), request.quantidade());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EstoqueDTO>> listarEstoque() {
        return ResponseEntity.ok(this.listarEstoqueUsece.listar());
    }
}
