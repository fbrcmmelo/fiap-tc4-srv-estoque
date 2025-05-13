package com.fiap.tc4_srv_estoque.usecase;

import com.fiap.tc4_srv_estoque.consumer.ProdutoRequest;
import com.fiap.tc4_srv_estoque.gateway.EstoqueGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IncrementarEstoqueUseCase implements IIncrementarEstoqueUseCase {

    private final EstoqueGateway gateway;

    @Override
    public void incrementar(ProdutoRequest produtoRequest) {
        if (produtoRequest.quantidade() <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }

        var produto = this.gateway.buscarProdutoPorId(produtoRequest.produtoId());
        produto.incrementar(produtoRequest.quantidade());

        this.gateway.atualizar(produto);
    }
}
