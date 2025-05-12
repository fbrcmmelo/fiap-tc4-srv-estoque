package com.fiap.tc4_srv_estoque.usecase;

import com.fiap.tc4_srv_estoque.domain.Produto;
import com.fiap.tc4_srv_estoque.gateway.EstoqueGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.mockito.Mockito.*;

class BaixaDeEstoqueUseCaseTest {

    private EstoqueGateway gateway;
    private BaixaDeEstoqueUseCase useCase;

    @BeforeEach
    void setUp() {
        gateway = mock(EstoqueGateway.class);
        useCase = new BaixaDeEstoqueUseCase(gateway);
    }

    @Test
    void decrementar_DeveReduzirEstoqueQuandoProdutoExistir() {
        // Arrange
        String produtoId = "123";
        int quantidade = 5;
        Produto produto = mock(Produto.class);

        when(gateway.buscarProdutoPorId(produtoId)).thenReturn(produto);

        // Act
        useCase.decrementar(produtoId, quantidade);

        // Assert
        verify(produto).decrementar(quantidade);
        verify(gateway).atualizar(produto);
    }

    @Test
    void decrementar_DeveLancarExcecaoQuandoQuantidadeForZeroOuNegativa() {
        // Arrange
        String produtoId = "123";

        // Act & Assert
        assertThatIllegalArgumentException()
                .isThrownBy(() -> useCase.decrementar(produtoId, 0))
                .withMessage("Quantidade deve ser maior que zero");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> useCase.decrementar(produtoId, -10))
                .withMessage("Quantidade deve ser maior que zero");
    }

    @Test
    void decrementar_DeveLancarExcecaoQuandoProdutoNaoEncontrado() {
        // Arrange
        String produtoId = "123";
        int quantidade = 5;

        when(gateway.buscarProdutoPorId(produtoId)).thenReturn(null);

        // Act & Assert
        assertThatIllegalArgumentException()
                .isThrownBy(() -> useCase.decrementar(produtoId, quantidade))
                .withMessage("Produto não encontrado no estoque");
    }
}
