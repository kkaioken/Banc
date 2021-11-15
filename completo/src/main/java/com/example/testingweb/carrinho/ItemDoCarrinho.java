package com.example.testingweb.carrinho;

import com.example.testingweb.produto.Produto;

public class ItemDoCarrinho {

	private Produto produto;
	private int quantidade;

	public ItemDoCarrinho(Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}
	
	public double getValorTotal() {
		return quantidade * produto.getValorUnitario();
	}

	public Produto getProduto() {
		return produto;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
}
