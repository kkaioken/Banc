package com.example.testingweb.carrinho;

public class AdicionadorDeItemAoCarrinho {

	private CarrinhoRepository carrinhoRepository;

	public AdicionadorDeItemAoCarrinho(CarrinhoRepository carrinhoRepository) {
		this.carrinhoRepository = carrinhoRepository;
	}

	public void adicionar(ItemDoCarrinho item, CarrinhoDeCompra carrinho) {
		carrinho.adicionar(item);
		carrinhoRepository.salvar(carrinho);
	}

}
