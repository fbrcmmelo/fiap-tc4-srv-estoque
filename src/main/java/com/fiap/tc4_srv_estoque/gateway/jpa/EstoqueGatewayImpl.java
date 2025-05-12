package com.fiap.tc4_srv_estoque.gateway.jpa;

import com.fiap.tc4_srv_estoque.domain.Produto;
import com.fiap.tc4_srv_estoque.gateway.EstoqueGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EstoqueGatewayImpl implements EstoqueGateway {

    private final EstoqueRepository estoqueRepository;

    @Override
    public void adicionarProduto(Produto produto) {
        this.estoqueRepository.save(new ProdutoJpaEntity(produto.getProdutoId(), produto.getQuantidade()));
    }

    @Override
    public Produto buscarProdutoPorId(String produtoId) {
        return this.estoqueRepository.findById(produtoId)
                .map(ProdutoJpaEntity::toDomain)
                .orElse(null);
    }

    @Override
    public void atualizar(Produto produto) {
        this.estoqueRepository.save(new ProdutoJpaEntity(produto.getProdutoId(), produto.getQuantidade()));
    }

    @Override
    public List<Produto> listar() {
        return this.estoqueRepository.findAll()
                .stream()
                .map(ProdutoJpaEntity::toDomain)
                .toList();
    }
}
