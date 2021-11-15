package com.example.testingweb.carrinho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarrinhoDeCompra {
	
	private List<ItemDoCarrinho> itensDoCarrinho;
	
	public CarrinhoDeCompra() {
		itensDoCarrinho = new ArrayList<ItemDoCarrinho>();
	}

	public void adicionar(ItemDoCarrinho itemDoCarrinho) {
		itensDoCarrinho.add(itemDoCarrinho);
	}

	public void remover(ItemDoCarrinho itemDoCarrinho) {
		itensDoCarrinho.remove(itemDoCarrinho);
	}

	public List<ItemDoCarrinho> getItensDoCarrinho() {
		return Collections.unmodifiableList(itensDoCarrinho);
	}
}
