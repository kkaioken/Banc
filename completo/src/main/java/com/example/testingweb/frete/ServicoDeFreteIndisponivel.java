package com.example.testingweb.frete;

public class ServicoDeFreteIndisponivel extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ServicoDeFreteIndisponivel() {
		super("O serviço de frete está indisponível no momento");
	}
}
