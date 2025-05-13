package com.fiap.tc4_srv_estoque.consumer;

import com.fiap.tc4_srv_estoque.usecase.IBaixaDeEstoqueUseCase;
import com.fiap.tc4_srv_estoque.usecase.IIncrementarEstoqueUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
public class EstoqueConsumer {

    private final IBaixaDeEstoqueUseCase decrementarEstoquUseCase;
    private final IIncrementarEstoqueUseCase incrementarEstoqueUseCase;

    @Bean("consumer/baixar-estoque")
    public Consumer<ProdutoRequest> baixarEstoque() {
        return request -> decrementarEstoquUseCase.decrementar(request.produtoId(), request.quantidade());
    }

    @Bean("consumer/incrementar-estoque")
    public Consumer<ProdutoRequest> incrementarEstoque() {
        return this.incrementarEstoqueUseCase::incrementar;
    }
}
