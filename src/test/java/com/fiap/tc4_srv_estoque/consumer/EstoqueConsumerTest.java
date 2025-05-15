package com.fiap.tc4_srv_estoque.consumer;

import com.fiap.tc4_srv_estoque.usecase.IBaixaDeEstoqueUseCase;
import com.fiap.tc4_srv_estoque.usecase.IIncrementarEstoqueUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.function.Consumer;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class EstoqueConsumerTest {

    @Mock
    private IBaixaDeEstoqueUseCase decrementarEstoquUseCase;
    @Mock
    private IIncrementarEstoqueUseCase incrementarEstoqueUseCase;

    @InjectMocks
    private EstoqueConsumer estoqueConsumer;

    @BeforeEach
    void EstoqueBaixarEstoqueTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void baixarEstoque() {
        ProdutoRequest request = new ProdutoRequest("1", 5);
        Consumer<ProdutoRequest> consumer = estoqueConsumer.baixarEstoque();

        consumer.accept(request);

        verify(decrementarEstoquUseCase, times(1)).decrementar("1", 5);
    }

    @Test
    void incrementarEstoque() {
        ProdutoRequest request = new ProdutoRequest("1", 10);
        Consumer<ProdutoRequest> consumer = estoqueConsumer.incrementarEstoque();

        consumer.accept(request);

        verify(incrementarEstoqueUseCase, times(1)).incrementar(request);
    }
}