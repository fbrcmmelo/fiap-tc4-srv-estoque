package com.fiap.tc4_srv_estoque.domain;

import lombok.Getter;

@Getter
public class Produto {

    private String produtoId;
    private int quantidade;

    public Produto(String produtoId, int quantidade) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    public void decrementar(int quantidade) {
        if (quantidade > this.quantidade) {
            throw new IllegalArgumentException("Quantidade insuficiente em estoque");
        }
        this.quantidade -= quantidade;
    }

    public void incrementar(int quantidade) {
        this.quantidade += quantidade;
    }
}
