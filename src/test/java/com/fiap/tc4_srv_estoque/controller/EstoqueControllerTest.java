package com.fiap.tc4_srv_estoque.controller;

import com.fiap.tc4_srv_estoque.consumer.ProdutoRequest;
import com.fiap.tc4_srv_estoque.usecase.IAdicionarProdutoUseCase;
import com.fiap.tc4_srv_estoque.usecase.IListarProdutoUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class EstoqueControllerTest {

    @Mock
    private IAdicionarProdutoUseCase adicionarProdutoUseCase;

    @Mock
    private IListarProdutoUseCase listarEstoqueUsece;

    @InjectMocks
    private EstoqueController estoqueController;

    public EstoqueControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void adicionarProduto() {
        ProdutoRequest request = new ProdutoRequest("1", 10);
        ResponseEntity<Void> response = estoqueController.adicionarProduto(request);

        verify(adicionarProdutoUseCase, times(1)).adicionar("1", 10);
        assertThat(response.getStatusCodeValue()).isEqualTo(201);
    }

    @Test
    void listarEstoque() {
        EstoqueDTO dto = new EstoqueDTO("1", 10);
        when(listarEstoqueUsece.listar()).thenReturn(List.of(dto));

        ResponseEntity<List<EstoqueDTO>> response = estoqueController.listarEstoque();

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).hasSize(1);
        assertThat(response.getBody().get(0).produtoId()).isEqualTo("1");
    }
}