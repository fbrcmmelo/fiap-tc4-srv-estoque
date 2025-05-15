package com.fiap.tc4_srv_estoque.usecase;

import com.fiap.tc4_srv_estoque.consumer.ProdutoRequest;
import com.fiap.tc4_srv_estoque.domain.Produto;
import com.fiap.tc4_srv_estoque.gateway.EstoqueGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

class IncrementarEstoqueUseCaseTest {

    @Mock
    private EstoqueGateway estoqueGateway;

    @InjectMocks
    private IncrementarEstoqueUseCase incrementarEstoqueUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void incrementarComQuantidadeValida() {
        ProdutoRequest request = new ProdutoRequest("1", 10);
        Produto produto = new Produto("1", 5);

        when(estoqueGateway.buscarProdutoPorId("1")).thenReturn(produto);

        incrementarEstoqueUseCase.incrementar(request);

        verify(estoqueGateway, times(1)).buscarProdutoPorId("1");
        verify(estoqueGateway, times(1)).atualizar(produto);
        assertThat(produto.getQuantidade()).isEqualTo(15);
    }

    @Test
    void incrementarComQuantidadeInvalida() {
        ProdutoRequest request = new ProdutoRequest("1", 0);

        assertThatThrownBy(() -> incrementarEstoqueUseCase.incrementar(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Quantidade deve ser maior que zero");

        verifyNoInteractions(estoqueGateway);
    }

    @Test
    void incrementarProdutoNaoEncontrado() {
        ProdutoRequest request = new ProdutoRequest("1", 10);

        when(estoqueGateway.buscarProdutoPorId("1")).thenReturn(null);

        assertThatThrownBy(() -> incrementarEstoqueUseCase.incrementar(request))
                .isInstanceOf(NullPointerException.class);

        verify(estoqueGateway, times(1)).buscarProdutoPorId("1");
        verify(estoqueGateway, never()).atualizar(any());
    }
}
