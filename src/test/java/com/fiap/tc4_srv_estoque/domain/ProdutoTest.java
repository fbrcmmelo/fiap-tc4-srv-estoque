package com.fiap.tc4_srv_estoque.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ProdutoTest {

    @Test
    void deveCriarProduto() {
        // Arrange & Act
        Produto produto = new Produto("123", 10);

        // Assert
        assertThat(produto.getProdutoId()).isEqualTo("123");
        assertThat(produto.getQuantidade()).isEqualTo(10);
    }

    @Test
    void decrementar_DeveReduzirQuantidadeQuandoQuantidadeSuficiente() {
        // Arrange
        Produto produto = new Produto("123", 10);

        // Act
        produto.decrementar(3);

        // Assert
        assertThat(produto.getQuantidade()).isEqualTo(7);
    }

    @Test
    void decrementar_DeveLancarExcecaoQuandoQuantidadeInsuficiente() {
        // Arrange
        Produto produto = new Produto("123", 5);

        // Act & Assert
        assertThatThrownBy(() -> produto.decrementar(10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Quantidade insuficiente em estoque");
    }

    @Test
    void incrementar_DeveAumentarQuantidade() {
        // Arrange
        Produto produto = new Produto("123", 5);

        // Act
        produto.incrementar(4);

        // Assert
        assertThat(produto.getQuantidade()).isEqualTo(9);
    }
}
