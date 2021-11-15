package com.example.testingweb.frete;

public class ServicoDeFreteIndisponivel extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ServicoDeFreteIndisponivel() {
		super("O servi�o de frete est� indispon�vel no momento");
	}
}
