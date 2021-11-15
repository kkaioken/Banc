package com.example.testingweb.produto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProdutoRequest {
	private String descricao;
	private double valorUnitario;
	
	ProdutoRequest() {
	}

	public ProdutoRequest(String descricao, double valorUnitario) {
		this.descricao = descricao;
		this.valorUnitario = valorUnitario;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}
}
