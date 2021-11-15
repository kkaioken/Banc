package com.example.testingweb.frete;

public interface ServicoDeFrete {
	double calcularFretePara(String cepDeOrigem, String cepDeDestino) throws ServicoDeFreteIndisponivel;
}
