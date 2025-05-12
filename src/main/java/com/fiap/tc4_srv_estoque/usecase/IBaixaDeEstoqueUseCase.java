package com.fiap.tc4_srv_estoque.usecase;

public interface IBaixaDeEstoqueUseCase {
    void decrementar(String produtoId, int quantidade);
}
