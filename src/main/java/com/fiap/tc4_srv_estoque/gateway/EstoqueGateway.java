package com.fiap.tc4_srv_estoque.gateway;

import com.fiap.tc4_srv_estoque.domain.Produto;

import java.util.List;

public interface EstoqueGateway {
    void adicionarProduto(Produto produto);

    Produto buscarProdutoPorId(String produtoId);

    void atualizar(Produto produto);

    List<Produto> listar();
}
