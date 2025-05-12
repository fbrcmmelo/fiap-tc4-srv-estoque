package com.fiap.tc4_srv_estoque.usecase;

import com.fiap.tc4_srv_estoque.controller.EstoqueDTO;
import com.fiap.tc4_srv_estoque.domain.Produto;
import com.fiap.tc4_srv_estoque.gateway.EstoqueGateway;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class ListarProdutoUseCaseTest {

    @Mock
    private EstoqueGateway estoqueGateway;

    @InjectMocks
    private ListarProdutosUseCase listarProdutoUseCase;

    public ListarProdutoUseCaseTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listar() {
        Produto produto = new Produto("1", 10);
        when(estoqueGateway.listar()).thenReturn(List.of(produto));

        List<EstoqueDTO> result = listarProdutoUseCase.listar();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).produtoId()).isEqualTo("1");
        assertThat(result.get(0).quantidade()).isEqualTo(10);
    }
}
