package com.fiap.tc4_srv_estoque.gateway.jpa;

import com.fiap.tc4_srv_estoque.domain.Produto;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class EstoqueGatewayImplTest {

    @Mock
    private EstoqueRepository estoqueRepository;

    @InjectMocks
    private EstoqueGatewayImpl estoqueGateway;

    public EstoqueGatewayImplTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void adicionarProduto() {
        Produto produto = new Produto("1", 10);
        estoqueGateway.adicionarProduto(produto);
        verify(estoqueRepository, times(1)).save(any(ProdutoJpaEntity.class));
    }

    @Test
    void buscarProdutoPorId() {
        ProdutoJpaEntity entity = new ProdutoJpaEntity("1", 10);
        when(estoqueRepository.findById("1")).thenReturn(Optional.of(entity));

        Produto result = estoqueGateway.buscarProdutoPorId("1");

        assertThat(result).isNotNull();
        assertThat(result.getProdutoId()).isEqualTo("1");
        assertThat(result.getQuantidade()).isEqualTo(10);
    }

    @Test
    void atualizar() {
        Produto produto = new Produto("1", 20);
        estoqueGateway.atualizar(produto);
        verify(estoqueRepository, times(1)).save(any(ProdutoJpaEntity.class));
    }

    @Test
    void listar() {
        ProdutoJpaEntity entity = new ProdutoJpaEntity("1", 10);
        when(estoqueRepository.findAll()).thenReturn(List.of(entity));

        List<Produto> result = estoqueGateway.listar();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getProdutoId()).isEqualTo("1");
        assertThat(result.get(0).getQuantidade()).isEqualTo(10);
    }
}