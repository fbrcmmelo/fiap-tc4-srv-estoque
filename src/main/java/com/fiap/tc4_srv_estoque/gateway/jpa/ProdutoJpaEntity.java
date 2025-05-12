package com.fiap.tc4_srv_estoque.gateway.jpa;

import com.fiap.tc4_srv_estoque.domain.Produto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document("estoque")
public class ProdutoJpaEntity {

    @Id
    private String produtoId;
    private int quantidade;

    public ProdutoJpaEntity(String produtoId, int quantidade) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    public Produto toDomain() {
        return new Produto(this.produtoId, this.quantidade);
    }
}
