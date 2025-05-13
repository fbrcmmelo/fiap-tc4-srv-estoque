package com.fiap.tc4_srv_estoque.usecase;

import com.fiap.tc4_srv_estoque.consumer.ProdutoRequest;

public interface IIncrementarEstoqueUseCase {

    void incrementar(ProdutoRequest produtoRequest);
}
