package com.fiap.tc4_srv_estoque.controller;

import com.fiap.tc4_srv_estoque.domain.Produto;

public record EstoqueDTO(String produtoId, int quantidade) {
    public static EstoqueDTO from(Produto produto) {
        return new EstoqueDTO(produto.getProdutoId(), produto.getQuantidade());
    }
}
