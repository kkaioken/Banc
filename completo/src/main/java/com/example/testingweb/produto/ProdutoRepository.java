package com.example.testingweb.produto;

import java.util.List;

public interface ProdutoRepository {
	void salvar(Produto produto);
	Produto buscarPelo(int id);
	List<Produto> buscarPorFaixaDePreco(double precoMinimo, double precoMaximo);
	List<Produto> buscarTodos();
	void excluir(int id);
}
