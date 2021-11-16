package com.example.testingweb.produto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProdutoResponse {

	private Long id;
	private String descricao;
	private double valorUnitario;
	
	ProdutoResponse() {
	}

	public ProdutoResponse(Long id, String descricao, double valorUnitario) {
		this.id = id;
		this.descricao = descricao;
		this.valorUnitario = valorUnitario;
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

}
