package com.fiap.tc4_srv_estoque.usecase;

import com.fiap.tc4_srv_estoque.domain.Produto;
import com.fiap.tc4_srv_estoque.gateway.EstoqueGateway;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class AdicionarProdutoUseCaseTest {

    @Mock
    private EstoqueGateway estoqueGateway;

    @InjectMocks
    private AdicionarProdutoUseCase adicionarProdutoUseCase;

    public AdicionarProdutoUseCaseTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void adicionar() {
        String produtoId = "1";
        int quantidade = 10;

        adicionarProdutoUseCase.adicionar(produtoId, quantidade);

        verify(estoqueGateway, times(1)).adicionarProduto(any(Produto.class));
    }
}
