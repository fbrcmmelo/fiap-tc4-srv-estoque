package com.fiap.tc4_srv_estoque.usecase;

import com.fiap.tc4_srv_estoque.domain.Produto;
import com.fiap.tc4_srv_estoque.gateway.EstoqueGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdicionarProdutoUseCase implements IAdicionarProdutoUseCase {

    private final EstoqueGateway gateway;

    @Override
    public void adicionar(String produtoId, int quantidade) {
        final var produto = new Produto(produtoId, quantidade);
        this.gateway.adicionarProduto(produto);
    }
}
