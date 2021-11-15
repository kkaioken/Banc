package com.example.testingweb.carrinho;

public interface CarrinhoRepository {
	void salvar(CarrinhoDeCompra carrinho);
	void buscarPelo(int id);
}
