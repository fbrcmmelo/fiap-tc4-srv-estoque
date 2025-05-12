package com.fiap.tc4_srv_estoque.usecase;

import com.fiap.tc4_srv_estoque.gateway.EstoqueGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BaixaDeEstoqueUseCase implements IBaixaDeEstoqueUseCase {

    private final EstoqueGateway gateway;

    @Override
    public void decrementar(String produtoId, int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }

        final var produto = this.gateway.buscarProdutoPorId(produtoId);

        if (produto == null) {
            throw new IllegalArgumentException("Produto não encontrado no estoque");
        }
        produto.decrementar(quantidade);
        this.gateway.atualizar(produto);
    }
}
