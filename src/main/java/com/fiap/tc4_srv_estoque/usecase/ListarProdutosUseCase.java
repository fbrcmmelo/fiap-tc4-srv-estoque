package com.fiap.tc4_srv_estoque.usecase;

import com.fiap.tc4_srv_estoque.controller.EstoqueDTO;
import com.fiap.tc4_srv_estoque.gateway.EstoqueGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ListarProdutosUseCase implements IListarProdutoUseCase {

    private final EstoqueGateway estoqueGateway;

    @Override
    public List<EstoqueDTO> listar() {
        return this.estoqueGateway.listar()
                .stream()
                .map(EstoqueDTO::from)
                .toList();
    }
}
