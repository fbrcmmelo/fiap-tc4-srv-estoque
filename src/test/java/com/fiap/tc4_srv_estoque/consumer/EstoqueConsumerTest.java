package com.fiap.tc4_srv_estoque.consumer;

import com.fiap.tc4_srv_estoque.usecase.IBaixaDeEstoqueUseCase;
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

    @InjectMocks
    private EstoqueConsumer estoqueConsumer;

    public EstoqueConsumerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void consumer() {
        ProdutoRequest request = new ProdutoRequest("1", 5);
        Consumer<ProdutoRequest> consumer = estoqueConsumer.consumer();

        consumer.accept(request);

        verify(decrementarEstoquUseCase, times(1)).decrementar("1", 5);
    }
}