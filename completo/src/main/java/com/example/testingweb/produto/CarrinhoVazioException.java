package com.example.testingweb.produto;

public class CarrinhoVazioException extends Exception {
	@Override
	public String getMessage() {
		return "O carrinho de compras não pode ser vazio.";
	}
}
