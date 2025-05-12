package com.fiap.tc4_srv_estoque.gateway.jpa;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends MongoRepository<ProdutoJpaEntity, String> {
}
