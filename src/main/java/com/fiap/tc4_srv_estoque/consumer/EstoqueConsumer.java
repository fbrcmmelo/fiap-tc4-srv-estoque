package com.fiap.tc4_srv_estoque.consumer;

import com.fiap.tc4_srv_estoque.usecase.IBaixaDeEstoqueUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
public class EstoqueConsumer {

    private final IBaixaDeEstoqueUseCase decrementarEstoquUseCase;

    @Bean(name = "baixar-estoque")
    public Consumer<ProdutoRequest> consumer() {
        return request -> decrementarEstoquUseCase.decrementar(request.produtoId(), request.quantidade());
    }
}
