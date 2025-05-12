package com.fiap.tc4_srv_estoque.usecase;

import com.fiap.tc4_srv_estoque.controller.EstoqueDTO;

import java.util.List;

public interface IListarProdutoUseCase {

    List<EstoqueDTO> listar();
}
